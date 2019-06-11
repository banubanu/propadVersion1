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
import com.prodapt.propad.dto.EmpTechDTO;
import com.prodapt.propad.dto.EmployeeEduDTO;
import com.prodapt.propad.dto.EmployeeProfDTO;
import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadEmpProfDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpEduRepository;
import com.prodapt.propad.service.EmpEdu;
import com.prodapt.propad.service.EmpTech;


@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/uploadedudocuments")
public class EduDocUpload {
	@Autowired
	EmpEdu empEdu;
	@Autowired
	EmpEduRepository empEduRepository;
	
	public EduDocUpload(EmpEdu empEdu) {
		// TODO Auto-generated constructor stub
		this.empEdu = empEdu;
	}
	
	@RequestMapping(value = "/record-exists", method = RequestMethod.GET)
    public ResponseEntity<Status> getsave(@RequestParam int ie_id){
           Status status=new Status();
           List<PropadEmpEduDetails> list=empEduRepository.findByIe_id(ie_id);
          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
             if(!list.isEmpty()&& list.size()>0) 
             { 
                    status.setStatusCode(200);
                    status.setPropadEmpEduDetails(list.get(0));
             }
           return new ResponseEntity<Status>(status, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/upload-edu-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpEduDetails uploadedudocument( @RequestPart(required = false) Map<String, String> json,EmployeeEduDTO empEdu, @RequestParam(required = false) MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4, @RequestParam(required=false) MultipartFile file5) throws IOException, SerialException, SQLException {
		System.out.println("banu"+file.getOriginalFilename());
		System.out.println(file.getBytes());
//		System.out.println(emptech.getEt_tech_cert1());
		
		PropadEmpEduDetails pee = new PropadEmpEduDetails();
//  pet.setEt_tech_cert1(((EmpTechDTO) file).getEt_tech_cert1());
//	pet.setEt_emp_id(et_emp_id);
		
//		pee.setEd_emp_id(empEdu.getEd_emp_id());
	pee.setEd_emp_mail(empEdu.getEd_emp_mail());
	pee.setIe_id(empEdu.getIe_id());
	if(file!=null) {
		pee.setEd_edu_sslc(file.getBytes());
		 pee.setSslc_status("Submitted");
	}else {
		 pee.setSslc_status("Not Submitted");
	}
	if(file1!=null) {
		 pee.setEd_edu_hsc(file1.getBytes());
		 pee.setHsc_status("Submitted");
	}
	else {
		pee.setHsc_status("Not Submitted");
	}
		if(file2!=null) {
		    pee.setEd_edu_dip(file2.getBytes());
		    pee.setDip_status("Submitted");
		}else {
			pee.setDip_status("Not Submitted");
		}
	if(file3!=null) {
		 pee.setEd_edu_ug(file3.getBytes());
		 pee.setUg_status("Submitted");
			
	}else {
		 pee.setUg_status("Not Submitted");
	}
		
   if(file4!=null) {
	   pee.setEd_edu_pg(file4.getBytes());
	   pee.setPg_status("Submitted");
   }else {
	   pee.setPg_status("Not Submitted");
   }

		return this.empEdu.save(pee) ;
	}

	@RequestMapping(value = "/update-edu-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpEduDetails updatedocument( @RequestPart(required = false) Map<String, String> json,EmployeeEduDTO empEdu, @RequestParam(required = false) MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4, @RequestParam(required = false) MultipartFile file5) throws IOException, SerialException, SQLException {
			System.out.println("hiii from function");
		/////////////////updated details////////////////
	PropadEmpEduDetails pee3 = new PropadEmpEduDetails();
		System.out.println("hiii from object");
		pee3.setEd_id(empEdu.getEd_id());
		pee3.setIe_id(empEdu.getIe_id());
		pee3.setEd_emp_mail(empEdu.getEd_emp_mail());
		if(file!=null) {
			pee3.setEd_edu_sslc(file.getBytes());
			
		}
		
			if(file1!=null) {
				pee3.setEd_edu_hsc(file1.getBytes());
			}
	        
	       
	        if(file2!=null) {
	        	pee3.setEd_edu_dip(file2.getBytes());
			}

	       
	        if(file3!=null) {
	        	pee3.setEd_edu_ug(file3.getBytes());
	       }
	        if(file4!=null) {
	        	pee3.setEd_edu_pg(file4.getBytes());
			}
	        if(file5!=null) {
	        	pee3.setEd_edu_others(file5.getBytes());
			}
		System.out.println("updarteed records"+pee3);
		
		
		PropadEmpEduDetails returnrecord=null;
	if( pee3.getEd_id()!=0)	{
		PropadEmpEduDetails pee2 = empEduRepository.getOne(pee3.getEd_id());
		System.out.println("record in database"+pee2);
		 if (pee2.getEd_emp_mail().equals( pee3.getEd_emp_mail())) {
			 PropadEmpEduDetails pee = new PropadEmpEduDetails();
			 pee.setEd_id(pee2.getEd_id());

			 pee.setIe_id(pee2.getIe_id());
//			 pee.setEd_emp_id(pee2.getEd_emp_mail());


			 pee.setEd_emp_mail(pee2.getEd_emp_mail());

			 if(pee3.getEd_edu_sslc()!=null) {
				 pee.setEd_edu_sslc(pee3.getEd_edu_sslc());
				 pee.setSslc_status("Submitted");
			 }else
			 {
				 pee.setEd_edu_sslc(pee2.getEd_edu_sslc());
				 pee.setSslc_status(pee2.getSslc_status());
			 }
			 if(pee3.getEd_edu_hsc()!=null) {
				 pee.setEd_edu_hsc(pee3.getEd_edu_hsc());
				 pee.setHsc_status("Submitted");
			 }else
			 {
				 pee.setEd_edu_hsc(pee2.getEd_edu_hsc());
				 pee.setHsc_status(pee2.getHsc_status());
			 }
			 if(pee3.getEd_edu_dip()!=null) {
				 pee.setEd_edu_dip(pee3.getEd_edu_dip());
				 pee.setDip_status("Submitted");
			 }else
			 {
				 pee.setEd_edu_dip(pee2.getEd_edu_dip());
				 pee.setDip_status(pee2.getDip_status());
			 }
			 if(pee3.getEd_edu_ug()!=null) {
				 pee.setEd_edu_ug(pee3.getEd_edu_ug());
				 pee.setUg_status("Submitted");
			 }else
			 {
				 pee.setEd_edu_ug(pee2.getEd_edu_ug());
				 pee.setUg_status(pee2.getUg_status());
			 }

			 if(pee3.getEd_edu_pg()!=null) {
				 pee.setEd_edu_pg(pee3.getEd_edu_pg());
				 pee.setPg_status("Submitted");
			 }else
			 {
				 pee.setEd_edu_pg(pee2.getEd_edu_pg());
				 pee.setPg_status(pee2.getPg_status());
			 }
			 
		 System.out.println("update of record needed");
		 returnrecord=pee;
		 System.out.println("updation done successfully");
	 }
		 else
		 {
			 returnrecord=pee3;
		 }
	}
	return this.empEdu.save(returnrecord);
	}

	
	
	@RequestMapping(value = "/update-edu-status", method = RequestMethod.POST)
	public PropadEmpEduDetails updatedocumentstatus( @RequestBody EmployeeEduDTO empEdu) throws IOException, SerialException, SQLException {
			System.out.println("hiii from function");
		/////////////////updated details////////////////
			System.out.println(empEdu);
	PropadEmpEduDetails pee3 = new PropadEmpEduDetails();
		System.out.println("hiii from object");
		pee3.setEd_id(empEdu.getEd_id());
		pee3.setIe_id(empEdu.getIe_id());
		pee3.setEd_emp_mail(empEdu.getEd_emp_mail());
		pee3.setSslc_status(empEdu.getSslc_status());
		pee3.setHsc_status(empEdu.getHsc_status());
		pee3.setDip_status(empEdu.getDip_status());
		pee3.setPg_status(empEdu.getPg_status());
		pee3.setUg_status(empEdu.getUg_status());
		
		System.out.println("updarteed records"+pee3);
		
		System.out.println(pee3.getEd_emp_mail());
		PropadEmpEduDetails returnrecord=null;
	if( pee3.getEd_emp_mail()!=null)	{
		System.out.println(pee3.getEd_emp_mail());
		PropadEmpEduDetails pee2 = empEduRepository.getOne(pee3.getEd_id());
		System.out.println("record in database"+pee2);
		 if (pee2.getEd_emp_mail().equals( pee3.getEd_emp_mail())) {
			 
			 PropadEmpEduDetails pee = new PropadEmpEduDetails();
			 pee.setEd_id(pee2.getEd_id());
			 pee.setIe_id(pee2.getIe_id());
			 pee.setEd_emp_mail(pee2.getEd_emp_mail()); 
			 pee.setEd_edu_sslc(pee2.getEd_edu_sslc());
			 pee.setEd_edu_hsc(pee2.getEd_edu_hsc());
			 pee.setEd_edu_dip( pee2.getEd_edu_dip());
			 pee.setEd_edu_ug(pee2.getEd_edu_ug());
			 pee.setEd_edu_pg(pee2.getEd_edu_pg()); 
			 pee.setSslc_status(pee3.getSslc_status());
			 pee.setUg_status(pee3.getUg_status());
			 pee.setHsc_status(pee3.getHsc_status());
			 pee.setDip_status(pee3.getDip_status());
			 pee.setPg_status(pee3.getPg_status());
			 
		 System.out.println("update of record needed");
		 returnrecord=pee;
		 System.out.println("updation done successfully");
	 }
		 else
		 {
			 returnrecord=pee3;
		 }
	}
	return this.empEdu.save(returnrecord);
	}

	@RequestMapping(value = "/upload-edu-camera", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpEduDetails uploadedudocumentcamera( @RequestBody EmployeeEduDTO empEdu) {
//		System.out.println("banu"+file.getOriginalFilename());
//		System.out.println(file.getBytes());
//		System.out.println(emptech.getEt_tech_cert1());
		
		PropadEmpEduDetails pee = new PropadEmpEduDetails();
//  pet.setEt_tech_cert1(((EmpTechDTO) file).getEt_tech_cert1());
//	pet.setEt_emp_id(et_emp_id);
		
//		pee.setEd_emp_id(empEdu.getEd_emp_id());
	pee.setEd_emp_mail(empEdu.getEd_emp_mail());
	pee.setIe_id(empEdu.getIe_id());
	if(empEdu.getEd_edu_sslc()!=null) {
		pee.setEd_edu_sslc(empEdu.getEd_edu_sslc());
		 pee.setSslc_status("Submitted");
	}else {
		 pee.setSslc_status("Not Submitted");
	}
	if(empEdu.getEd_edu_hsc()!=null) {
		 pee.setEd_edu_hsc(empEdu.getEd_edu_hsc());
		 pee.setHsc_status("Submitted");
	}
	else {
		pee.setHsc_status("Not Submitted");
	}
		if(empEdu.getEd_edu_dip()!=null) {
		    pee.setEd_edu_dip(empEdu.getEd_edu_dip());
		    pee.setDip_status("Submitted");
		}else {
			pee.setDip_status("Not Submitted");
		}
	if(empEdu.getEd_edu_ug()!=null) {
		 pee.setEd_edu_ug(empEdu.getEd_edu_ug());
		 pee.setUg_status("Submitted");
			
	}else {
		 pee.setUg_status("Not Submitted");
	}
		
   if(empEdu.getEd_edu_pg()!=null) {
	   pee.setEd_edu_pg(empEdu.getEd_edu_pg());
	   pee.setPg_status("Submitted");
   }else {
	   pee.setPg_status("Not Submitted");
   }

		return this.empEdu.save(pee) ;
	}
	@RequestMapping(value = "/update-edu-camera", method = RequestMethod.POST)
	public PropadEmpEduDetails updatedocumentcamera( @RequestPart(required = false) Map<String, String> json,EmployeeEduDTO empEdu, @RequestParam(required = false) MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4, @RequestParam(required = false) MultipartFile file5) throws IOException, SerialException, SQLException {
			System.out.println("hiii from function");
		/////////////////updated details////////////////
	PropadEmpEduDetails pee3 = new PropadEmpEduDetails();
		System.out.println("hiii from object");
		pee3.setEd_id(empEdu.getEd_id());
		pee3.setIe_id(empEdu.getIe_id());
		pee3.setEd_emp_mail(empEdu.getEd_emp_mail());
		if(empEdu.getEd_edu_sslc()!=null) {
			pee3.setEd_edu_sslc(empEdu.getEd_edu_sslc());
			
		}
		
			if(empEdu.getEd_edu_hsc()!=null) {
				pee3.setEd_edu_hsc(empEdu.getEd_edu_hsc());
			}
	        
	       
	        if(empEdu.getEd_edu_dip()!=null) {
	        	pee3.setEd_edu_dip(empEdu.getEd_edu_dip());
			}

	       
	        if(empEdu.getEd_edu_ug()!=null) {
	        	pee3.setEd_edu_ug(empEdu.getEd_edu_ug());
	       }
	        if(empEdu.getEd_edu_pg()!=null) {
	        	pee3.setEd_edu_pg(empEdu.getEd_edu_pg());
			}
	      
		System.out.println("updarteed records"+pee3);
		
		
		PropadEmpEduDetails returnrecord=null;
	if( pee3.getEd_id()!=0)	{
		PropadEmpEduDetails pee2 = empEduRepository.getOne(pee3.getEd_id());
		System.out.println("record in database"+pee2);
		 if (pee2.getEd_emp_mail().equals( pee3.getEd_emp_mail())) {
			 PropadEmpEduDetails pee = new PropadEmpEduDetails();
			 pee.setEd_id(pee2.getEd_id());

			 pee.setIe_id(pee2.getIe_id());
//			 pee.setEd_emp_id(pee2.getEd_emp_mail());


			 pee.setEd_emp_mail(pee2.getEd_emp_mail());

			 if(pee3.getEd_edu_sslc()!=null) {
				 pee.setEd_edu_sslc(pee3.getEd_edu_sslc());
				 pee.setSslc_status("Submitted");
			 }else
			 {
				 pee.setEd_edu_sslc(pee2.getEd_edu_sslc());
				 pee.setSslc_status(pee2.getSslc_status());
			 }
			 if(pee3.getEd_edu_hsc()!=null) {
				 pee.setEd_edu_hsc(pee3.getEd_edu_hsc());
				 pee.setHsc_status("Submitted");
			 }else
			 {
				 pee.setEd_edu_hsc(pee2.getEd_edu_hsc());
				 pee.setHsc_status(pee2.getHsc_status());
			 }
			 if(pee3.getEd_edu_dip()!=null) {
				 pee.setEd_edu_dip(pee3.getEd_edu_dip());
				 pee.setDip_status("Submitted");
			 }else
			 {
				 pee.setEd_edu_dip(pee2.getEd_edu_dip());
				 pee.setDip_status(pee2.getDip_status());
			 }
			 if(pee3.getEd_edu_ug()!=null) {
				 pee.setEd_edu_ug(pee3.getEd_edu_ug());
				 pee.setUg_status("Submitted");
			 }else
			 {
				 pee.setEd_edu_ug(pee2.getEd_edu_ug());
				 pee.setUg_status(pee2.getUg_status());
			 }

			 if(pee3.getEd_edu_pg()!=null) {
				 pee.setEd_edu_pg(pee3.getEd_edu_pg());
				 pee.setPg_status("Submitted");
			 }else
			 {
				 pee.setEd_edu_pg(pee2.getEd_edu_pg());
				 pee.setPg_status(pee2.getPg_status());
			 }
			 
		 System.out.println("update of record needed");
		 returnrecord=pee;
		 System.out.println("updation done successfully");
	 }
		 else
		 {
			 returnrecord=pee3;
		 }
	}
	return this.empEdu.save(returnrecord);
	}

}






		
		
		
	

