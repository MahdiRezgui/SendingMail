package com.SpringBoot.LeuvilleObjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
	@Autowired
	private NotificationService notificationService;
	
	@RequestMapping("/signup")
	public String signup() {
		return "Please sign up";
	}
	

	@RequestMapping("/signup-sucess")
	public String signupSucess() {
		
		//Send notification
		User user=new User();
		user.setFirstName("mahdi");
		user.setLastName("Rezgui");
		user.setEmailAddress("rizgui.mahdi@gmail.com");
		
		try {
			notificationService.sendNotification(user);
		}catch(MailException e ) {
			e.printStackTrace();
		}
		
		return "Thank you for registreting with us";
	}
}
