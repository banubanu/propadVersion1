package com.prodapt.propad.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.propad.service.EmpPer;
import com.prodapt.propad.service.EmpProf;

@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/getstatus")
public class ProfStatusController {
	@Autowired
	EmpProf empProf;
	public ProfStatusController(EmpPer empPer) {
		// TODO Auto-generated constructor stub
		this.empProf = empProf;
	}
	
	@RequestMapping(value = "/get-prof-status", method = RequestMethod.GET)
	public Integer getpersonalstatus(@RequestParam("ie_id") int ie_id ) {
		if(this.empProf.countnull(ie_id)==null) {
			return -1;
		}
		return this.empProf.countnull(ie_id);
	}
	
	
}
