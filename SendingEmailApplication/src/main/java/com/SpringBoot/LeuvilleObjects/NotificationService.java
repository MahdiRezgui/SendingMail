package com.SpringBoot.LeuvilleObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	
	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender=javaMailSender;
	}
	
	public void sendNotification(User user) throws MailException{
		SimpleMailMessage mail=new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("rizgui.mahdi@gmail.com");
		mail.setSubject("new Email");
		mail.setText("This is a cool email notification");
		javaMailSender.send(mail);
	}
}
