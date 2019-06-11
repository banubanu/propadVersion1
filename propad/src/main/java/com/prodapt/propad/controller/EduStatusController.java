package com.prodapt.propad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.propad.service.EmpEdu;
@RestController
@CrossOrigin("*")
@RequestMapping("/getstatus")
public class EduStatusController {

	@Autowired
	EmpEdu empEdu;
	public EduStatusController(EmpEdu empEdu) {
		// TODO Auto-generated constructor stub
		this.empEdu = empEdu;
	}	
	
	@RequestMapping(value = "/get-edu-status", method = RequestMethod.GET)
	public Integer getedudocuments(@RequestParam("ie_id") int ie_id ) {
		System.out.println(ie_id);
		if(this.empEdu.countnull(ie_id)==null) {
//			System.out.println("null value");
			return -1;
		}
//		System.out.println(this.empEdu.countnull(ie_id)+ "   null 4 value");
		return this.empEdu.countnull(ie_id);
	}
	
}
