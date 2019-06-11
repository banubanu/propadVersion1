package com.prodapt.propad.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.prodapt.propad.dto.EmpTechDTO;
import com.prodapt.propad.dto.EmployeeDTO;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.PropadInitiateEmployee;
import com.prodapt.propad.repository.ServiceRepository;
import com.prodapt.propad.service.ServiceApi;

@RestController
@CrossOrigin("*")
@RequestMapping("/initateemp")
public class ServiceController {
@Autowired
	ServiceApi serviceApi;
@Autowired
ServiceRepository serviceRepository;
	public ServiceController(ServiceApi serviceApi) {
		// TODO Auto-generated constructor stub
		this.serviceApi = serviceApi;
	}

	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
	public PropadInitiateEmployee getAll() {
		EmployeeDTO employee = new EmployeeDTO();
		PropadInitiateEmployee pie = new PropadInitiateEmployee();
		
		
	    pie.setIe_emp_name(employee.getIe_emp_name());
	   
		pie.setIe_emp_email(employee.getIe_emp_email());
		
		pie.setIe_emp_id(employee.getIe_emp_id());
		pie.setIe_id(employee.getIe_id());
		
//		pie.setIe_int1(employee.getIe_int1());
//		
//		pie.setIe_int2(employee.getIe_int2());
		
		pie.setIe_status(employee.getIe_status());
		
        System.out.println(this.serviceApi.getAll());
		return this.serviceApi.save(pie);
	}
	
	
	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public PropadInitiateEmployee addUser(@RequestBody EmployeeDTO employee) {
		System.out.println("hi");
		System.out.println(employee.getIe_emp_name());
		PropadInitiateEmployee pie = new PropadInitiateEmployee();
		pie.setIe_emp_name(employee.getIe_emp_name());

//		pie.setIe_emp_name(employee.getIe_emp_name());
        pie.setIe_emp_doj(employee.getIe_emp_doj());
        pie.setIe_emp_date(new Date());

	    pie.setIe_emp_email(employee.getIe_emp_email());
		pie.setIe_emp_id(employee.getIe_emp_id());
//		pie.setIe_int1(employee.getIe_int1()); 
//		pie.setIe_int2(employee.getIe_int2());
		pie.setIe_status(employee.getIe_status());
		return this.serviceApi.save(pie) ;
	}
	
	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public PropadInitiateEmployee updateuser(@RequestBody EmployeeDTO employee) throws  SerialException {
		System.out.println("hiii from function");
		/////////////////updated details////////////////
		PropadInitiateEmployee pet3 = new PropadInitiateEmployee();
		System.out.println("hiii from object");
pet3.setIe_id(employee.getIe_id());
		pet3.setIe_emp_email(employee.getIe_emp_email());
		pet3.setIe_emp_id(employee.getIe_emp_id());
		System.out.println("updarteed records"+pet3);
		
		
		PropadInitiateEmployee returnrecord=null;
	if( pet3.getIe_id()!=0)	{
		PropadInitiateEmployee pet2 = serviceRepository.getOne(pet3.getIe_id());
		System.out.println("record in database"+pet2);
		 if (pet2.getIe_id() == pet3.getIe_id()) {
			 PropadInitiateEmployee pet = new PropadInitiateEmployee();
			 pet.setIe_id(pet2.getIe_id());
             pet.setIe_emp_doj(pet2.getIe_emp_doj());
             pet.setIe_emp_name(pet2.getIe_emp_name());
             pet.setIe_emp_email(pet3.getIe_emp_email());
             pet.setIe_emp_id(pet3.getIe_emp_id());
             pet.setIe_emp_date(pet2.getIe_emp_date());
			 pet.setIe_status(pet2.getIe_status());
			 
			
			 
		 System.out.println("update of record needed");
		 returnrecord=pet;
		 System.out.println("updation done successfully");
	 }
		 else
		 {
			 returnrecord=pet3;
		 }
	}
	return this.serviceApi.save(returnrecord);
	}
	
	
	@RequestMapping(value = "/update-user-status", method = RequestMethod.POST)
	public PropadInitiateEmployee updateuserStatus(@RequestBody EmployeeDTO employee) throws  SerialException {
		/////////////////updated details////////////////
		PropadInitiateEmployee pet3 = new PropadInitiateEmployee();
		System.out.println("hiii from object");
pet3.setIe_id(employee.getIe_id());
		pet3.setIe_status(employee.getIe_status());
				System.out.println("updarteed records"+pet3);
		
		
		PropadInitiateEmployee returnrecord=null;
	if( pet3.getIe_id()!=0)	{
		PropadInitiateEmployee pet2 = serviceRepository.getOne(pet3.getIe_id());
		System.out.println("record in database"+pet2);
		 if (pet2.getIe_id() == pet3.getIe_id()) {
			 PropadInitiateEmployee pet = new PropadInitiateEmployee();
			 pet.setIe_id(pet2.getIe_id());
             pet.setIe_emp_doj(pet2.getIe_emp_doj());
             pet.setIe_emp_name(pet2.getIe_emp_name());
             pet.setIe_emp_email(pet2.getIe_emp_email());
             pet.setIe_emp_id(pet2.getIe_emp_id());
             pet.setIe_emp_date(pet2.getIe_emp_date());
			 pet.setIe_status(pet3.getIe_status());
			 
			
			 
		 System.out.println("update of record needed");
		 returnrecord=pet;
		 System.out.println("updation done successfully");
	 }
		 else
		 {
			 returnrecord=pet3;
		 }
	}
	return this.serviceApi.save(returnrecord);
	}
	
	
	@RequestMapping(value = "/get-updated-user", method = RequestMethod.GET)
	public List<PropadInitiateEmployee> updateUsers(@RequestParam("ie_emp_mail") String ie_emp_mail) {
		return this.serviceApi.getOneRow(ie_emp_mail);
	}
	
	@RequestMapping(value = "/get-users", method = RequestMethod.GET)
	public List<PropadInitiateEmployee> getUsers() {
		return this.serviceApi.getAll();
	}
	@RequestMapping(value = "/get-users/", method = RequestMethod.GET)
	public List<PropadInitiateEmployee> getUser(@RequestParam("ie_emp_mail") String ie_emp_mail) {
		return this.serviceApi.getOneRow(ie_emp_mail);
	}
	
	@RequestMapping(value = "/checkusername", method = RequestMethod.GET)
	public List<PropadInitiateEmployee> checkusername(@RequestParam("ie_emp_mail") String ie_emp_mail) {
		return this.serviceApi.getOneRow(ie_emp_mail);
	}
	
//	@RequestMapping(value = "/update-document-status", method = RequestMethod.POST)
//	public PropadInitiateEmployee updatedocumentStatus(@RequestBody EmployeeDTO employee) throws  SerialException {
//		/////////////////updated details////////////////
//		PropadInitiateEmployee pet3 = new PropadInitiateEmployee();
//		System.out.println("hiii from object");
//pet3.setIe_id(employee.getIe_id());
//		pet3.setIe_document_status(employee.getIe_document_status());
//				System.out.println("updarteed records"+pet3);
//		
//		
//		PropadInitiateEmployee returnrecord=null;
//	if( pet3.getIe_id()!=0)	{
//		PropadInitiateEmployee pet2 = serviceRepository.getOne(pet3.getIe_id());
//		System.out.println("record in database"+pet2);
//		 if (pet2.getIe_id() == pet3.getIe_id()) {
//			 PropadInitiateEmployee pet = new PropadInitiateEmployee();
//			 pet.setIe_id(pet2.getIe_id());
//             pet.setIe_emp_doj(pet2.getIe_emp_doj());
//             pet.setIe_emp_name(pet2.getIe_emp_name());
//             pet.setIe_emp_email(pet2.getIe_emp_email());
//             pet.setIe_emp_id(pet2.getIe_emp_id());
//             pet.setIe_emp_date(pet2.getIe_emp_date());
//			 pet.setIe_document_status(pet3.getIe_document_status());
// 
//		 System.out.println("update of record needed");
//		 returnrecord=pet;
//		 System.out.println("updation done successfully");
//	 }
//		 else
//		 {
//			 returnrecord=pet3;
//		 }
//	}
//	return this.serviceApi.save(returnrecord);
//	}
	
}
