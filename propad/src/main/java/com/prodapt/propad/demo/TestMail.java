package com.prodapt.propad.demo;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.propad.dto.EmployeeValDTO;

@RestController
@CrossOrigin("*")
public class TestMail {

	
	@Autowired
	private MailSenderService mailSenderService;
	
	@GetMapping("test")
	public String getTest() {
		return "hello";
	}
	
	
	 
	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	    public String sendMail(@RequestParam("user_email") String user_email, @RequestParam("user_password") String user_password) {
		EmailProperties emailProperties=new EmailProperties();
		
		emailProperties.setFrom("banu.b@prodapt.com");
		String s=user_email;
		String pwd=user_password;
		System.out.println(s);
		emailProperties.setTo(s);
		emailProperties.setBody("hi,"
				+ "your username is "+ s
				+" your password is" +pwd );
		emailProperties.setSubject("initiation process");
		try {
			mailSenderService.sendEmployeeMessage(emailProperties);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			
		}
	        return "Mail Sent Success!";
	    }
	
	
	
	@RequestMapping(value = "/resendDocumentMail", method = RequestMethod.POST)
    public String resendDocumentMail( @RequestBody EmployeeValDTO empVal ) {
		System.out.println(empVal.getEv_emp_mail());
		 String[] empValComment = new String[50];
		 int length ;
		 String s= "Dear Prodaptian,\n Some of your documents are not valid as you need to update those documents your HR comments are given below:" ;
		 
			for(int i=0;i<empVal.getA().length;i++) {
				length = empVal.getA().length;
				s += " "+ empVal.getA()[i];
				
				
		}

	EmailProperties emailProperties=new EmailProperties();

	emailProperties.setFrom("banu.b@prodapt.com");
	emailProperties.setTo(empVal.getEv_emp_mail());
	int i=0;
	emailProperties.setBody(s);
	
	emailProperties.setSubject("Document Not valid");
	
	try {
		mailSenderService.sendEmployeeMessage(emailProperties);
	} catch (MessagingException | IOException e) {
		// TODO Auto-generated catch block
		
	}
        return "Mail Sent Success!";
    }
	
	
	@RequestMapping(value = "/sendcompletedDocumentMail", method = RequestMethod.POST)
    public String documentStatusUpdate(@RequestBody EmployeeValDTO empVal ) {
	
	EmailProperties emailProperties=new EmailProperties();

	emailProperties.setFrom("banu.b@prodapt.com");
	emailProperties.setTo(empVal.getEv_emp_mail());
	emailProperties.setCc("vaishnavi.s@prodapt.com");
	String s= "Dear prodaptian,"+ "\n" +"you have successfully uploaded ";
	
	emailProperties.setBody(s+empVal.getSectionname()+"\n"+"Thanks,\n Onboarding Support Team");
	
	emailProperties.setSubject("OnBoardingPro Document uploaded - %");
	
	try {
		mailSenderService.sendEmployeeMessage(emailProperties);
	} catch (MessagingException | IOException e) {
		// TODO Auto-generated catch block
		
	}
        return "Mail Sent Success!";
    }
	
	
	
	
}
