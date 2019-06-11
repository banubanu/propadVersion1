package com.prodapt.propad.controller;


import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.prodapt.propad.dto.EmployeeValDTO;



@RestController
@CrossOrigin("*")

public class MailService {
       
  @Autowired
    private JavaMailSender sender;

    

  @RequestMapping(value = "/sendMail", method = RequestMethod.POST)
  public String sendMail(@RequestParam("user_email") String user_email, @RequestParam("user_password") String user_password) {
                SimpleMailMessage message =new SimpleMailMessage();

                message.setTo(user_email);
                message.setSubject("Onboarding Employee Initiation process");
                message.setFrom("propad.notifications@prodapt.com");
//                message.setCc(elNomination.getElRmEmail());
                String s=user_email;
        		String pwd=user_password;
                message.setText("Dear Prodaptian,\r\n You are allowed to access Prodapt network to upload your document. Please find your credentials below: "
        				+ "\nUsername: "+ s +"\r"
        				+"\nPassword: " +pwd +"\r\n Thanks,\r\n Onboarding Support Team");   
                sender.send(message);     
                return "Mail Sent Success!";
}
  
  
  @RequestMapping(value = "/resendDocumentMail", method = RequestMethod.POST)
  public String resendDocumentMail( @RequestBody EmployeeValDTO empVal ) {
//	  String[] empValComment = new String[50];
//		 int length ;
		 

		 String s= "Dear Prodaptian,\n\r\nThe document you have uploaded in "+empVal.getSectionname()+" ("+empVal.getDocumentName()+")"+" is not valid.Please upload the correct document.\n\rRejected Reason: "+empVal.getEv_review_comments()+"\n\rThanks\n\rPropad Support Team" ;
		 
//			for(int i=0;i<empVal.getA().length;i++) {
//				length = empVal.getA().length;
//				s += " "+ empVal.getA()[i];
//				
//				
//		}
	  SimpleMailMessage message =new SimpleMailMessage();

                message.setTo(empVal.getEv_emp_mail());
                message.setSubject("Document Not valid");
                message.setFrom("propad.notifications@prodapt.com");
//                message.setCc(elNomination.getElRmEmail());
               
                message.setText(s);   
                sender.send(message);     
                return "Mail Sent Success!";
}
  
  
  @RequestMapping(value = "/sendcompletedDocumentMail", method = RequestMethod.POST)
  public String documentStatusUpdate(@RequestBody EmployeeValDTO empVal ) {
	  SimpleMailMessage message =new SimpleMailMessage();
	  String s= "Dear Prodaptian,\r \n You have successfully uploaded ";
                message.setTo(empVal.getEv_emp_mail());
                message.setSubject("OnBoardingPro Document Uploaded");
                message.setFrom("propad.notifications@prodapt.com");
//              
                message.setText(s+empVal.getSectionname()+"."+"\r\n\n"+"Thanks,\r\n\n Onboarding Support Team" );   
                sender.send(message);     
                return "Mail Sent Success!";
}

	       	
                
                
    }
