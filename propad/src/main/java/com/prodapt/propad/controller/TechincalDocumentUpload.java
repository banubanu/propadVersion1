package com.prodapt.propad.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonParseException;
import com.prodapt.propad.dto.EmpTechDTO;
import com.prodapt.propad.dto.EmployeeEduDTO;
import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpTechRepository;
import com.prodapt.propad.service.EmpTech;

@Controller
@RestController
@CrossOrigin("*")
@JsonIgnoreType

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@RequestMapping("/uploadtechdocuments")
public class TechincalDocumentUpload {
		
		@Autowired
		EmpTech empTech;
		@Autowired
		EmpTechRepository empTechRepository;
		
		public TechincalDocumentUpload(EmpTech empTech) {
			// TODO Auto-generated constructor stub
			this.empTech = empTech;
		}
		
		@RequestMapping(value = "/record-exists", method = RequestMethod.GET)
	    public ResponseEntity<Status> getsave(@RequestParam int ie_id){
	           Status status=new Status();
	           List<PropadEmpTechDetails> list=empTechRepository.findByIe_id(ie_id);
	          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
	             if(!list.isEmpty()&& list.size()>0) 
	             { 
	                    status.setStatusCode(200);
	                    status.setPropadEmpTechDetails(list.get(0));
	             }
	           return new ResponseEntity<Status>(status, HttpStatus.OK);
	    }
//		@RequestMapping(value = "/record-exists", method = RequestMethod.GET)
//	    public ResponseEntity<Status> getsave1(@RequestParam int ie_id){
//	           Status status=new Status();
//	           List<PropadEmpTechDetails> list=empTechRepository.findByIe_id(ie_id);
//	          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
//	             if(!list.isEmpty()&& list.size()>0) 
//	             { 
//	                    status.setStatusCode(200);
//	                    status.setPropadEmpTechDetails(list.get(0));
//	             }
//	           return new ResponseEntity<Status>(status, HttpStatus.OK);
//   }
//	
	
	@RequestMapping(value = "/upload-tech-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpTechDetails uploaddocumentModel( @RequestPart(required = false) Map<String, String> json, EmpTechDTO emptech, @RequestParam("file") MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4) throws IOException, SerialException, SQLException {
		System.out.println("test"+file.getOriginalFilename());
		System.out.println(file.getBytes());
//		System.out.println(emptech.getEt_tech_cert1());
		
	PropadEmpTechDetails pet = new PropadEmpTechDetails();
//  pet.setEt_tech_cert1(((EmpTechDTO) file).getEt_tech_cert1());
//	pet.setEt_emp_id(et_emp_id);
	pet.setIe_id(emptech.getIe_id());
	pet.setEt_emp_mail(emptech.getEt_emp_mail());

	if(file!=null) {
		pet.setEt_tech_cert1(file.getBytes());
		 pet.setTech1_status("Submitted");
	}else {
		 pet.setTech1_status("Not Submitted");
	}
	
		
		if(file1!=null) {
			pet.setEt_tech_cert2(file1.getBytes());
			pet.setTech2_status("Submitted");
		}else {
			pet.setTech2_status("Not Submitted");
		}
        
       
        if(file2!=null) {
        	pet.setEt_tech_cert3(file2.getBytes());
        	 pet.setTech3_status("Submitted");
		}else {
			pet.setTech3_status("Not Submitted");
		}

       
        if(file3!=null) {
        	pet.setEt_tech_cert4(file3.getBytes());
        	 pet.setTech4_status("Submitted");
       }else {
    	   pet.setTech4_status("Not Submitted");
       }
        if(file4!=null) {
        	pet.setEt_tech_cert5(file4.getBytes());
        	pet.setTech5_status("Submitted");
		}else {
			pet.setTech5_status("Not Submitted");
		}
        System.out.println("testing "+ emptech.getEt_id());
        pet.setEt_tech_cert1_text(emptech.getEt_tech_cert1_text());
        pet.setEt_tech_cert2_text(emptech.getEt_tech_cert2_text());
        pet.setEt_tech_cert3_text(emptech.getEt_tech_cert3_text());
        pet.setEt_tech_cert4_text(emptech.getEt_tech_cert4_text());
        pet.setEt_tech_cert5_text(emptech.getEt_tech_cert5_text());
        pet.setEt_tech_comments(emptech.getEt_tech_comments());
		return this.empTech.save(pet) ;
	}
	
	
	
	
	@RequestMapping(value = "/update-tech-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpTechDetails updatedocumentModel( @RequestPart(required = false) Map<String, String> json, EmpTechDTO emptech, @RequestParam(required = false) MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4) throws IOException, SerialException, SQLException,JsonParseException {
		System.out.println("hiii from function");
		/////////////////updated details////////////////
		PropadEmpTechDetails pet3 = new PropadEmpTechDetails();
		System.out.println("hiii from object");
		pet3.setEt_id(emptech.getEt_id());
        pet3.setIe_id(emptech.getIe_id());
		System.out.println(emptech.getEt_emp_mail());
		pet3.setEt_emp_mail(emptech.getEt_emp_mail());
		

		if(file!=null) {
			pet3.setEt_tech_cert1(file.getBytes());
		}
		
			if(file1!=null) {
				pet3.setEt_tech_cert2(file1.getBytes());
			}
	        
	       
	        if(file2!=null) {
	        	pet3.setEt_tech_cert3(file2.getBytes());
			}

	       
	        if(file3!=null) {
	        	pet3.setEt_tech_cert4(file3.getBytes());
	       }
	        if(file4!=null) {
	        	pet3.setEt_tech_cert5(file4.getBytes());
			}
	        pet3.setTech1_status(emptech.getTech1_status());
	        pet3.setTech2_status(emptech.getTech2_status());
	        pet3.setTech3_status(emptech.getTech3_status());
            pet3.setTech4_status(emptech.getTech4_status());
            pet3.setTech5_status(emptech.getTech5_status());
		System.out.println("updarteed records"+pet3);
		
		
PropadEmpTechDetails returnrecord=null;
	if( pet3.getEt_id()!=0)	{
		PropadEmpTechDetails pet2 = empTechRepository.getOne(pet3.getEt_id());
		System.out.println("record in database"+pet2);
		 if (pet2.getIe_id() == pet3.getIe_id()) {
			 PropadEmpTechDetails pet = new PropadEmpTechDetails();
			 pet.setEt_id(pet2.getEt_id());
			 pet.setIe_id(pet2.getIe_id());
			 pet.setEt_emp_mail(pet2.getEt_emp_mail());
			 if(pet3.getEt_tech_cert1()!=null) {
				 pet.setEt_tech_cert1(pet3.getEt_tech_cert1());
				 pet.setTech1_status("Submitted");
			 }else
			 {
				 pet.setEt_tech_cert1(pet2.getEt_tech_cert1());
				 pet.setTech1_status(pet2.getTech1_status());
			 }
			 if(pet3.getEt_tech_cert2()!=null) {
				 pet.setEt_tech_cert2(pet3.getEt_tech_cert2());
				 pet.setTech2_status("Submitted");
			 }else
			 {
				 pet.setEt_tech_cert2(pet2.getEt_tech_cert2());
				 pet.setTech2_status(pet2.getTech2_status());
			 }
			 if(pet3.getEt_tech_cert3()!=null) {
				 pet.setEt_tech_cert3(pet3.getEt_tech_cert3());
				  pet.setTech3_status("Submitted");
			 }else
			 {
				 pet.setEt_tech_cert3(pet2.getEt_tech_cert3());
				  pet.setTech3_status(pet2.getTech3_status());
			 }
			 if(pet3.getEt_tech_cert4()!=null) {
				 pet.setEt_tech_cert4(pet3.getEt_tech_cert4());
				 pet.setTech4_status("Submitted");
			 }else
			 {
				 pet.setEt_tech_cert4(pet2.getEt_tech_cert4());
				 pet.setTech4_status(pet2.getTech4_status());
			 }
			 if(pet3.getEt_tech_cert5()!=null) {
				 pet.setEt_tech_cert5(pet3.getEt_tech_cert5());
				 pet.setTech5_status("Submitted");
			 }else
			 {
				 pet.setEt_tech_cert5(pet2.getEt_tech_cert5());
				 pet.setTech5_status(pet2.getTech5_status());
			 }
			
           
            
            
		 System.out.println("update of record needed");
		 returnrecord=pet;
		 System.out.println("updation done successfully");

		 
		 
		 }
		 else
		 {
			 returnrecord=pet3;

		 }
	}
	return this.empTech.save(returnrecord);
	}
	
	
	@RequestMapping(value = "/update-tech-status", method = RequestMethod.POST)
    public PropadEmpTechDetails updatedocumentStatus( @RequestBody EmpTechDTO emptech) throws IOException, SerialException, SQLException,JsonParseException {
                        System.out.println("hiii from function");
           /////////////////updated details////////////////
                        PropadEmpTechDetails pet3 = new PropadEmpTechDetails();
           System.out.println("hiii from object");
           pet3.setEt_id(emptech.getEt_id());
           pet3.setIe_id(emptech.getIe_id());
           pet3.setEt_emp_mail(emptech.getEt_emp_mail());
           pet3.setTech1_status(emptech.getTech1_status());
           pet3.setTech2_status(emptech.getTech2_status());
           pet3.setTech3_status(emptech.getTech3_status());
           pet3.setTech4_status(emptech.getTech4_status());
           pet3.setTech5_status(emptech.getTech5_status());

           System.out.println("updarteed records"+pet3);
           
           
           PropadEmpTechDetails returnrecord=null;
    if( pet3.getEt_emp_mail()!=null)  {
//         PropadEmpTechDetails pet2 = empTechRepository.getOneRow(pet3.getEt_emp_mail());
           PropadEmpTechDetails pet2 = empTechRepository.getOne(pet3.getEt_id());
           System.out.println("record in database"+pet2);
           if (pet2.getEt_emp_mail().equals(pet3.getEt_emp_mail())) {
                  PropadEmpTechDetails pet = new PropadEmpTechDetails();
                  pet.setEt_id(pet2.getEt_id());
                  pet.setIe_id(pet2.getIe_id());
                  pet.setEt_emp_mail(pet2.getEt_emp_mail());
                  
                  pet.setEt_tech_cert1(pet2.getEt_tech_cert1());
                  pet.setEt_tech_cert2(pet2.getEt_tech_cert2());
                  pet.setEt_tech_cert3(pet2.getEt_tech_cert3());
                  pet.setEt_tech_cert4(pet2.getEt_tech_cert4());
                  pet.setEt_tech_cert5(pet2.getEt_tech_cert5());
                  
                  pet.setTech1_status(pet3.getTech1_status());
                  pet.setTech2_status(pet3.getTech2_status());
                  pet.setTech3_status(pet3.getTech3_status());
                  pet.setTech4_status(pet3.getTech4_status());
                  pet.setTech5_status(pet3.getTech5_status());
                  
            System.out.println("update of record needed");
           returnrecord=pet;
           System.out.println("updation done successfully");
    }
           else
           {
                  returnrecord=pet3;
           }
    }
    return this.empTech.save(returnrecord);
    }
	@RequestMapping(value = "/upload-tech-camera", method = RequestMethod.POST)
	public PropadEmpTechDetails uploaddocumentcamera( @RequestBody EmpTechDTO emptech) {
//		System.out.println("test"+file.getOriginalFilename());
//		System.out.println(file.getBytes());
//		System.out.println(emptech.getEt_tech_cert1());
		
	PropadEmpTechDetails pet = new PropadEmpTechDetails();
//  pet.setEt_tech_cert1(((EmpTechDTO) file).getEt_tech_cert1());
//	pet.setEt_emp_id(et_emp_id);
	pet.setIe_id(emptech.getIe_id());
	pet.setEt_emp_mail(emptech.getEt_emp_mail());

	if(emptech.getEt_tech_cert1()!=null) {
		pet.setEt_tech_cert1(emptech.getEt_tech_cert1());
		 pet.setTech1_status("Submitted");
	}else {
		 pet.setTech1_status("Not Submitted");
	}
	
		
		if(emptech.getEt_tech_cert2()!=null) {
			pet.setEt_tech_cert2(emptech.getEt_tech_cert2());
			pet.setTech2_status("Submitted");
		}else {
			pet.setTech2_status("Not Submitted");
		}
        
       
        if(emptech.getEt_tech_cert3()!=null) {
        	pet.setEt_tech_cert3(emptech.getEt_tech_cert3());
        	 pet.setTech3_status("Submitted");
		}else {
			pet.setTech3_status("Not Submitted");
		}

       
        if(emptech.getEt_tech_cert4()!=null) {
        	pet.setEt_tech_cert4(emptech.getEt_tech_cert4());
        	 pet.setTech4_status("Submitted");
       }else {
    	   pet.setTech4_status("Not Submitted");
       }
        if(emptech.getEt_tech_cert5()!=null) {
        	pet.setEt_tech_cert5(emptech.getEt_tech_cert5());
        	pet.setTech5_status("Submitted");
		}else {
			pet.setTech5_status("Not Submitted");
		}
        System.out.println("testing "+ emptech.getEt_id());
        pet.setEt_tech_cert1_text(emptech.getEt_tech_cert1_text());
        pet.setEt_tech_cert2_text(emptech.getEt_tech_cert2_text());
        pet.setEt_tech_cert3_text(emptech.getEt_tech_cert3_text());
        pet.setEt_tech_cert4_text(emptech.getEt_tech_cert4_text());
        pet.setEt_tech_cert5_text(emptech.getEt_tech_cert5_text());
        pet.setEt_tech_comments(emptech.getEt_tech_comments());
		return this.empTech.save(pet) ;
	}
	@RequestMapping(value = "/update-tech-camera", method = RequestMethod.POST)
	public PropadEmpTechDetails updatedocumentcamera( @RequestBody EmpTechDTO emptech) {
		System.out.println("hiii from function");
		/////////////////updated details////////////////
		PropadEmpTechDetails pet3 = new PropadEmpTechDetails();
		System.out.println("hiii from object");
		pet3.setEt_id(emptech.getEt_id());
        pet3.setIe_id(emptech.getIe_id());
		System.out.println(emptech.getEt_emp_mail());
		pet3.setEt_emp_mail(emptech.getEt_emp_mail());
		

		if(emptech.getEt_tech_cert1()!=null) {
			pet3.setEt_tech_cert1(emptech.getEt_tech_cert1());
		}
		
			if(emptech.getEt_tech_cert2()!=null) {
				pet3.setEt_tech_cert2(emptech.getEt_tech_cert2());
			}
	        
	       
	        if(emptech.getEt_tech_cert3()!=null) {
	        	pet3.setEt_tech_cert3(emptech.getEt_tech_cert3());
			}

	       
	        if(emptech.getEt_tech_cert4()!=null) {
	        	pet3.setEt_tech_cert4(emptech.getEt_tech_cert4());
	       }
	        if(emptech.getEt_tech_cert5()!=null) {
	        	pet3.setEt_tech_cert5(emptech.getEt_tech_cert5());
			}
	        pet3.setTech1_status(emptech.getTech1_status());
	        pet3.setTech2_status(emptech.getTech2_status());
	        pet3.setTech3_status(emptech.getTech3_status());
            pet3.setTech4_status(emptech.getTech4_status());
            pet3.setTech5_status(emptech.getTech5_status());
		System.out.println("updarteed records"+pet3);
		
		
PropadEmpTechDetails returnrecord=null;
	if( pet3.getEt_id()!=0)	{
		PropadEmpTechDetails pet2 = empTechRepository.getOne(pet3.getEt_id());
		System.out.println("record in database"+pet2);
		 if (pet2.getIe_id() == pet3.getIe_id()) {
			 PropadEmpTechDetails pet = new PropadEmpTechDetails();
			 pet.setEt_id(pet2.getEt_id());
			 pet.setIe_id(pet2.getIe_id());
			 pet.setEt_emp_mail(pet2.getEt_emp_mail());
			 if(pet3.getEt_tech_cert1()!=null) {
				 pet.setEt_tech_cert1(pet3.getEt_tech_cert1());
				 pet.setTech1_status("Submitted");
			 }else
			 {
				 pet.setEt_tech_cert1(pet2.getEt_tech_cert1());
				 pet.setTech1_status(pet2.getTech1_status());
			 }
			 if(pet3.getEt_tech_cert2()!=null) {
				 pet.setEt_tech_cert2(pet3.getEt_tech_cert2());
				 pet.setTech2_status("Submitted");
			 }else
			 {
				 pet.setEt_tech_cert2(pet2.getEt_tech_cert2());
				 pet.setTech2_status(pet2.getTech2_status());
			 }
			 if(pet3.getEt_tech_cert3()!=null) {
				 pet.setEt_tech_cert3(pet3.getEt_tech_cert3());
				  pet.setTech3_status("Submitted");
			 }else
			 {
				 pet.setEt_tech_cert3(pet2.getEt_tech_cert3());
				  pet.setTech3_status(pet2.getTech3_status());
			 }
			 if(pet3.getEt_tech_cert4()!=null) {
				 pet.setEt_tech_cert4(pet3.getEt_tech_cert4());
				 pet.setTech4_status("Submitted");
			 }else
			 {
				 pet.setEt_tech_cert4(pet2.getEt_tech_cert4());
				 pet.setTech4_status(pet2.getTech4_status());
			 }
			 if(pet3.getEt_tech_cert5()!=null) {
				 pet.setEt_tech_cert5(pet3.getEt_tech_cert5());
				 pet.setTech5_status("Submitted");
			 }else
			 {
				 pet.setEt_tech_cert5(pet2.getEt_tech_cert5());
				 pet.setTech5_status(pet2.getTech5_status());
			 }
			
           
            
            
		 System.out.println("update of record needed");
		 returnrecord=pet;
		 System.out.println("updation done successfully");

		 
		 
		 }
		 else
		 {
			 returnrecord=pet3;

		 }
	}
	return this.empTech.save(returnrecord);
	}
	
	
}