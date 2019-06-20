package com.prodapt.propad.controller;

import java.io.IOException;
import java.sql.SQLException;
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
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.propad.dto.CompanyApplicationDTO;
import com.prodapt.propad.dto.IdcardDTO;
import com.prodapt.propad.model.CompanyApplicationForm;
import com.prodapt.propad.model.IdCardForm;
import com.prodapt.propad.repository.CompanyApplicationRepository;
import com.prodapt.propad.service.CompanyApp;


@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/companyapplication")
public class CompanyApplicationController {
	@Autowired
	CompanyApp companyApp;
	@Autowired
	CompanyApplicationRepository companyApplicationRepository;
	
	public CompanyApplicationController(CompanyApp companyApp) {
		// TODO Auto-generated constructor stub
		this.companyApp = companyApp;
	}
	@RequestMapping(value = "/get-companyapp", method = RequestMethod.GET)
	public List<CompanyApplicationForm> getcomapnyappForm(@RequestParam("ie_id") int ie_id) {
		
		return this.companyApp.getByIe_id(ie_id);
}
	@RequestMapping(value = "/upload-company-form", method = RequestMethod.POST)
	
	public CompanyApplicationForm uploadpersonaldocument(@RequestBody CompanyApplicationDTO companyApp) {
	
//		
//		CompanyApplicationForm caf = new CompanyApplicationForm();
//		caf.setIe_id(companyApp.getIe_id());
//		caf.setCa_firstname(companyApp.getCa_firstname());
//		caf.setCa_lastname(companyApp.getCa_lastname());
//		caf.setCa_dob(companyApp.getCa_dob());
//		caf.setCa_doj(companyApp.getCa_doj());
//		caf.setCa_maritalstatus(companyApp.getCa_maritalstatus());
	
		
		
		
		
		
		
		return this.companyApp.saveDemo(companyApp);
	}

}
