package com.prodapt.propad.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.propad.dto.EmployeeDTO;
import com.prodapt.propad.dto.UsersDTO;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.PropadInitiateEmployee;
import com.prodapt.propad.model.PropadUsers;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.UserRepository;
import com.prodapt.propad.service.EmpPer;
import com.prodapt.propad.service.User;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	User user;
	@Autowired
	UserRepository userRepository;
	
	public UserController(User user) {
		// TODO Auto-generated constructor stub
		this.user = user;
	}
	
	@RequestMapping(value = "/record-exists", method = RequestMethod.GET)
    public ResponseEntity<Status> getsave(@RequestParam String user_password){
           Status status=new Status();
           List<PropadUsers> list=userRepository.findByUserPassword(user_password);
          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
             if(!list.isEmpty()&& list.size()>0) 
             { 
                    status.setStatusCode(200);
                    status.setPropadUser(list.get(0));
             }
           return new ResponseEntity<Status>(status, HttpStatus.OK);
    }
	
	//for-login
//	@RequestMapping(value = "/get-user-status", method = RequestMethod.GET)
//	public List<PropadUsers> getUserStatus(@RequestParam("user_email") String user_email, @RequestParam("user_password") String user_password  ) {
//		
//		return this.user.findByUserEmailAndUserPassword(user_email, user_password);
//	}
//	
	@RequestMapping(value = "/get-user-status", method = RequestMethod.GET)
	  public ResponseEntity<Status> getstatus(@RequestParam("username") String user_email, @RequestParam("password") String user_password){
          Status status=new Status();
          List<PropadUsers> list=user.findByUserEmailAndUserPassword(user_email, user_password);
         // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
            if(!list.isEmpty()&& list.size()>0) 
            { 
                   status.setStatusCode(200);
                   status.setPropadUser(list.get(0));
            }
          return new ResponseEntity<Status>(status, HttpStatus.OK);
   }
	
	
	
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public PropadUsers addUser(@RequestBody UsersDTO user) {
		System.out.println("hi");
		PropadUsers pu = new PropadUsers();
		pu.setUser_email(user.getUser_email());

        pu.setUser_password(user.getUser_password());

		return this.user.save(pu) ;
	}
}
