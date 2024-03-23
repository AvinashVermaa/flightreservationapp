package com.flightreservation_app.util;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtilImpl implements EmailUtil{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtilImpl.class);

	@Autowired
	private JavaMailSender sender;

	@Override
	public void sendEmail(String to,File file) throws Exception {
		LOGGER.info("Inside sendEmail() to : "+to+" File : "+file);
		MimeMessage mimeMessage = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
		helper.setTo(to);
		helper.setSubject("First Ticket");
		helper.setText("Hello Attached the ticket in the email,Please check it..");
		helper.addAttachment("Iternary Ticket", file);
		
		sender.send(mimeMessage);
		
	}
}
