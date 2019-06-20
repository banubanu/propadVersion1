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
import com.prodapt.propad.dto.IdcardDTO;
import com.prodapt.propad.model.IdCardForm;
import com.prodapt.propad.repository.IdcardRepository;

import com.prodapt.propad.service.Idcard;


@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/idcard")
public class IdcardController {
	@Autowired
	Idcard idcard;
	@Autowired
	IdcardRepository idrepository;
	
	public IdcardController(Idcard idcard) {
		// TODO Auto-generated constructor stub
		this.idcard = idcard;
	}
	
	@RequestMapping(value = "/get-idcard", method = RequestMethod.GET)
	public List<IdCardForm> getidcardForm(@RequestParam("ie_id") int ie_id) {
		
		return this.idcard.getByIe_id(ie_id);
}
	@RequestMapping(value = "/upload-idcard-form", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	
	public IdCardForm uploadpersonaldocument(@RequestPart(required = false) Map<String, String> json, IdcardDTO idcardobject, @RequestParam MultipartFile photo, @RequestParam MultipartFile sign)throws IOException, SerialException, SQLException {
	
		
		IdCardForm idc = new IdCardForm();
		
		System.out.println("hiii from object");
		
		idc.setIe_id(idcardobject.getIe_id());
		idc.setIc_emp_name(idcardobject.getIc_emp_name());
		idc.setIc_empcode(idcardobject.getIc_empcode());
		idc.setIc_address(idcardobject.getIc_address());
		idc.setIc_bloodgroup(idcardobject.getIc_bloodgroup());
		idc.setIc_mobile(idcardobject.getIc_mobile());
		idc.setIc_vehicle1_make(idcardobject.getIc_vehicle1_make());
		idc.setIc_vehicle1_model(idcardobject.getIc_vehicle1_model());
		idc.setIc_vehicle1_name(idcardobject.getIc_vehicle1_name());
		idc.setIc_vehicle1_regn(idcardobject.getIc_vehicle1_regn());
		idc.setIc_vehicle2_make(idcardobject.getIc_vehicle2_make());
		idc.setIc_vehicle2_model(idcardobject.getIc_vehicle2_model());
		idc.setIc_vehicle2_name(idcardobject.getIc_vehicle2_name());
		idc.setIc_vehicle2_regn(idcardobject.getIc_vehicle2_regn());
		idc.setIc_photo(photo.getBytes());
		idc.setIc_sign(sign.getBytes());
		
		
		return this.idcard.save(idc);
	}
}
