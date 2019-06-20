package com.prodapt.propad.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.prodapt.propad.dto.MediclaimDTO;
import com.prodapt.propad.model.MediclaimForm;

import com.prodapt.propad.repository.MediclaimRepository;

import com.prodapt.propad.service.Mediclaim;


@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/mediclaim")
public class MediclaimController {

	@Autowired
	Mediclaim mediclaim;
	@Autowired
	MediclaimRepository mediclaimrepository;
	
	public MediclaimController(Mediclaim mediclaim) {
		// TODO Auto-generated constructor stub
		this.mediclaim = mediclaim;
	}
	
	@RequestMapping(value = "/get-mediclaim", method = RequestMethod.GET)
	public List<MediclaimForm> getMediclaimForm(@RequestParam("ie_id") int ie_id) {
		System.out.println("in getMediclaimForm");
		return this.mediclaim.getByIe_id(ie_id);
}
	@RequestMapping(value = "/upload-mediclaim-form", method = RequestMethod.POST)
	
	public MediclaimForm uploadpersonaldocument(@RequestBody MediclaimDTO medi){
	
		
		MediclaimForm mc3 = new MediclaimForm();
		
		System.out.println("hiii from object");
		
		mc3.setIe_id(medi.getIe_id());
		mc3.setMc_spouse_name(medi.getMc_spouse_name());
		mc3.setMc_spouse_dob(medi.getMc_spouse_dob());
		mc3.setMc_father_name(medi.getMc_father_name());
		mc3.setMc_father_dob(medi.getMc_father_dob());
		mc3.setMc_mother_name(medi.getMc_mother_name());
		mc3.setMc_mother_dob(medi.getMc_mother_dob());
		mc3.setMc_child1_name(medi.getMc_child1_name());
		mc3.setMc_child1_dob(medi.getMc_child1_dob());
		mc3.setMc_child1_sex(medi.getMc_child1_sex());
		mc3.setMc_child2_name(medi.getMc_child2_name());
		mc3.setMc_child2_dob(medi.getMc_child2_dob());
		mc3.setMc_child2_sex(medi.getMc_child2_sex());
		
		return this.mediclaim.save(mc3);
	}
	
	@RequestMapping(value = "/update-mediclaim-form", method = RequestMethod.POST)
	public MediclaimForm updatepersonaldocument(@RequestBody MediclaimDTO medi){
		System.out.println("hiii from function");
		/////////////////updated details////////////////
		
		MediclaimForm mc3 = new MediclaimForm();
		
		System.out.println("hiii from object");
		
		mc3.setIe_id(medi.getIe_id());
		
		mc3.setMc_spouse_name(medi.getMc_spouse_name());
		mc3.setMc_spouse_dob(medi.getMc_spouse_dob());
		mc3.setMc_father_name(medi.getMc_father_name());
		mc3.setMc_father_dob(medi.getMc_father_dob());
		mc3.setMc_mother_name(medi.getMc_mother_name());
		mc3.setMc_mother_dob(medi.getMc_mother_dob());
		mc3.setMc_child1_name(medi.getMc_child1_name());
		mc3.setMc_child1_dob(medi.getMc_child1_dob());
		mc3.setMc_child1_sex(medi.getMc_child1_sex());
		mc3.setMc_child2_name(medi.getMc_child2_name());
		mc3.setMc_child2_dob(medi.getMc_child2_dob());
		mc3.setMc_child2_sex(medi.getMc_child2_sex());
		
		
		MediclaimForm returnrecord=null;
	if( mc3.getMc_id()!=0)	{
		MediclaimForm mc2 = mediclaimrepository.getOne(mc3.getMc_id());
		System.out.println("record in database"+mc2);
		 if (mc2.getIe_id() == mc2.getIe_id()) {
			 MediclaimForm mc = new MediclaimForm();
			 mc.setIe_id(mc2.getIe_id());
				mc.setMc_id(mc2.getMc_id());
				mc.setMc_spouse_name(mc2.getMc_spouse_name());
				mc.setMc_spouse_dob(mc2.getMc_spouse_dob());
				mc.setMc_father_name(mc2.getMc_father_name());
				mc.setMc_father_dob(mc2.getMc_father_dob());
				mc.setMc_mother_name(mc2.getMc_mother_name());
				mc.setMc_mother_dob(mc2.getMc_mother_dob());
				mc.setMc_child1_name(mc2.getMc_child1_name());
				mc.setMc_child1_dob(mc2.getMc_child1_dob());
				mc.setMc_child1_sex(mc2.getMc_child1_sex());
				mc.setMc_child2_name(mc2.getMc_child2_name());
				mc.setMc_child2_dob(mc2.getMc_child2_dob());
				mc.setMc_child2_sex(mc2.getMc_child2_sex());
			
			 		 
		 System.out.println("update of record needed");
		 returnrecord=mc;
		 System.out.println("updation done successfully");
		 }
		 else
		 {
			 returnrecord=mc3;
		 }
	}
	return this.mediclaim.save(returnrecord);
	}

	
	
	
	
}
