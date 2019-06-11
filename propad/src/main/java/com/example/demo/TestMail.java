package com.example.demo;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class TestMail {

	
	@Autowired
	private MailSenderService mailSenderService;
	
	@GetMapping("test")
	public String getTest() {
		return "hello";
	}
	
	
	 

	@GetMapping("/sendMail")
	
	 // public String sendMail(@RequestParam String ie_emp_email, String from, String to, String subject, String body)
	    
	public String sendMail(@RequestParam String ie_emp_email, String from, String to, String subject, String body) {
		EmailProperties emailProperties=new EmailProperties();
		
		emailProperties.setFrom("Survey.Notifications@prodapt.com");
		//emailProperties.setTo(new String[]{"nandini.ps@prodapt.com","gayathri.j@prodapt.com"}); //For Group recepients
		emailProperties.setTo(ie_emp_email);
		emailProperties.setBody("hi");
		emailProperties.setSubject("test");
		
		

		
		
		try {
			mailSenderService.sendEmployeeMessage(emailProperties);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			
		}
	        return "Mail Sent Success!";
	    }

}
