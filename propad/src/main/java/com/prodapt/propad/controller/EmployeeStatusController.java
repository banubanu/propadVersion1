package com.prodapt.propad.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.propad.dto.EmpTechDTO;
import com.prodapt.propad.dto.EmployeeDTO;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.PropadInitiateEmployee;
import com.prodapt.propad.service.EmpEdu;
import com.prodapt.propad.service.EmpTech;
import com.prodapt.propad.service.ServiceApi;

@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/getstatus")
public class EmployeeStatusController {
	@Autowired
	EmpTech empTech;
	
	public EmployeeStatusController(EmpTech empTech) {
		// TODO Auto-generated constructor stub
		this.empTech = empTech;
	}
	
//	@RequestMapping(value = { "/", "" }, method = RequestMethod.GET)
//	public PropadEmpTechDetails getAll() {
//		EmpTechDTO emptech = new EmpTechDTO();
//		PropadEmpTechDetails pet = new PropadEmpTechDetails();
//		pet.setEt_emp_id(emptech.getEt_emp_id());
//		pet.setEt_tech_cert1(emptech.getEt_tech_cert1());
//		pet.setEt_tech_cert1_text(emptech.getEt_tech_cert1_text());
//		pet.setEt_tech_cert2(emptech.getEt_tech_cert2());
//		pet.setEt_tech_cert2_text(emptech.getEt_tech_cert2_text());
//		pet.setEt_tech_cert3(emptech.getEt_tech_cert3());
//		pet.setEt_tech_cert3_text(emptech.getEt_tech_cert3_text());
//		pet.setEt_tech_cert4(emptech.getEt_tech_cert4());
//		pet.setEt_tech_cert4_text(emptech.getEt_tech_cert4_text());
//		pet.setEt_tech_cert5(emptech.getEt_tech_cert5());
//		pet.setEt_tech_cert5_text(emptech.getEt_tech_cert5_text());
//	    System.out.println("hi");
//		return this.empTech.save(pet);
//	}
	//upload via fileSystem.
//	@RequestMapping(value="/uploads",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException{
//		File convertFile= new File("D:\\images\\uploads\\"+file.getOriginalFilename());
//		convertFile.createNewFile();
//		FileOutputStream fout=new FileOutputStream(convertFile);
//		fout.write(file.getBytes());
//		fout.close();
	
//		return new ResponseEntity<>("File uploaded Succesfuflly",HttpStatus.OK) ;
//	}
	
	
//	@RequestMapping(value = "/upload-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public PropadEmpTechDetails uploaddocumentModel( @RequestPart(required = false) Map<String, String> json, EmpTechDTO emptech, @RequestParam("file") MultipartFile file, @RequestParam("file1") MultipartFile file1,@RequestParam("file2") MultipartFile file2,@RequestParam("file3") MultipartFile file3,@RequestParam("file4") MultipartFile file4) throws IOException, SerialException, SQLException {
//		System.out.println("test"+file.getOriginalFilename());
//		System.out.println(file.getBytes());
////		System.out.println(emptech.getEt_tech_cert1());
//		
//	PropadEmpTechDetails pet = new PropadEmpTechDetails();
////  pet.setEt_tech_cert1(((EmpTechDTO) file).getEt_tech_cert1());
////	pet.setEt_emp_id(et_emp_id);
//	pet.setEt_emp_id(emptech.getEt_emp_id());
//	pet.setEt_tech_cert1(file.getBytes());
//		pet.setEt_tech_cert1_text(emptech.getEt_tech_cert1_text());
//        pet.setEt_tech_cert2(file1.getBytes());
//        pet.setEt_tech_cert2_text(emptech.getEt_tech_cert2_text());
//        pet.setEt_tech_cert3(file2.getBytes());
//        pet.setEt_tech_cert3_text(emptech.getEt_tech_cert3_text());
//        pet.setEt_tech_cert4(file3.getBytes());
//        pet.setEt_tech_cert4_text(emptech.getEt_tech_cert4_text());
//        pet.setEt_tech_cert5(file4.getBytes());
//        pet.setEt_tech_cert5_text(emptech.getEt_tech_cert5_text());
//        pet.setEt_tech_comments(emptech.getEt_tech_comments());
//		return this.empTech.save(pet) ;
//	}
	
	
	@RequestMapping(value = "/get-tech-status", method = RequestMethod.GET)
	public Integer gettechdocuments(@RequestParam("ie_id") int ie_id ) {
		if(this.empTech.countnull(ie_id)==null) {
			return -1;
		}
		
		return this.empTech.countnull(ie_id);
		
	}
	

	
	
}
