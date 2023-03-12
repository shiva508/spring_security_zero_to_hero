package com.security.service.mail;

import java.io.FileNotFoundException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.security.config.mail.EmailCfg;
import com.security.forms.Feedback;

@Component
public class MailService {
	@Autowired
	private EmailCfg emailCfg;
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendFeedback(Feedback feedback) {

		/*
		 * // Create a mail sender JavaMailSenderImpl mailSender = new
		 * JavaMailSenderImpl(); mailSender.setHost(this.emailCfg.getHost());
		 * mailSender.setPort(this.emailCfg.getPort());
		 * mailSender.setUsername(this.emailCfg.getUsername());
		 * mailSender.setPassword(this.emailCfg.getPassword());
		 * 
		 * // Create an email instance SimpleMailMessage mailMessage = new
		 * SimpleMailMessage(); mailMessage.setFrom(feedback.getEmail());
		 * mailMessage.setTo("daasrishiva1@gmail.com");
		 * mailMessage.setSubject("New feedback from " + feedback.getName());
		 * mailMessage.setText(feedback.getFeedback()); // Send mail
		 * mailSender.send(mailMessage);
		 */

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = null;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(feedback.getEmail());
			mimeMessageHelper.setSubject("Test Mail");
			mimeMessageHelper.setText("<h1>Check attachment for image!</h1>", true);
			mimeMessageHelper.addAttachment("my_photo.png", ResourceUtils.getFile("/images/android.png"));

	        javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
