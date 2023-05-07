package com.pool.service.mail;

import java.io.FileNotFoundException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import com.pool.config.mail.EmailCfg;
import com.pool.forms.Feedback;

@Component
public class MailService {
	@Autowired
	private EmailCfg emailCfg;
	@Autowired
	private JavaMailSender javaMailSender;

	public void sendFeedback(Feedback feedback) {

		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = null;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setTo(feedback.getEmail());
			mimeMessageHelper.setSubject("Test Mail");
			mimeMessageHelper.setText("<h1>Check attachment for image!</h1>", true);
			mimeMessageHelper.addAttachment("my_photo.png", ResourceUtils.getFile("/images/android.png"));

	        javaMailSender.send(mimeMessage);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (jakarta.mail.MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
