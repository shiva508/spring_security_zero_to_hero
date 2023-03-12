package com.pool.service.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

import com.security.constants.EmailConstants;
import com.security.oauth.model.UserModel;
import com.sun.mail.smtp.SMTPTransport;

@Component
public class EmailService {

	public Session getCurrentEmailSession() {
		
		Properties properties=System.getProperties();
		properties.put(EmailConstants.SMTP_HOST, EmailConstants.GMAIL_SMTP_SERVER);
		properties.put(EmailConstants.SMTP_AUTH, true);
		properties.put(EmailConstants.SMTP_PORT, EmailConstants.DEFAULT_PORT);
		properties.put(EmailConstants.SMTP_STARTTLS_ENABLE, true);
		properties.put(EmailConstants.SMTP_STARTTLS_REQUIRED, true);
		
		return Session.getInstance(properties, null);
	}
	
	public Message emailTemplateGeneter(UserModel userModel) {
		
		Message message=new MimeMessage(getCurrentEmailSession());
		
		try {
			
			message.setFrom(new InternetAddress(EmailConstants.FROM_EMAIL));
			message.setRecipients(RecipientType.TO, InternetAddress.parse(userModel.getEmail(), false));
			message.setRecipients(RecipientType.CC, InternetAddress.parse(EmailConstants.CC_EMAIL, false));
			message.setSubject(EmailConstants.EMAIL_SUBJECT);
			message.setText("Your password:"+userModel.getPassword());
			message.saveChanges();
			
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		return message;
	}
	
	public void emailSender(UserModel userModel) {
		Message message=emailTemplateGeneter(userModel);
		
		try {
			SMTPTransport smtpTransport=(SMTPTransport) getCurrentEmailSession().getTransport(EmailConstants.SIMPLE_MAIL_TRANSFER_PROTOCOL);
			smtpTransport.connect(EmailConstants.GMAIL_SMTP_SERVER,EmailConstants.USERNAME,EmailConstants.PASSWORD);
			smtpTransport.sendMessage(message, message.getAllRecipients());
			smtpTransport.close();
			
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
