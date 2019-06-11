package com.prodapt.propad.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.rowset.serial.SerialException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.fasterxml.jackson.core.JsonParseException;
import com.prodapt.propad.dto.EmpTechDTO;
import com.prodapt.propad.dto.EmployeeEduDTO;
import com.prodapt.propad.dto.EmployeeProfDTO;
import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadEmpProfDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpProfRepository;
import com.prodapt.propad.service.EmpProf;


@Controller
@RestController
@CrossOrigin("*")
@RequestMapping("/getemployeeprofessionaldetails")
public class EmpProfUpload {
	@Autowired
	
	EmpProf empProf;
	@Autowired
	EmpProfRepository empProfRepository;
	@Value("${application.base.media}")
    private String storagePath;

	
	public EmpProfUpload(EmpProf empProf)
	{
		this.empProf = empProf;
	}

	@RequestMapping(value = "/record-exists", method = RequestMethod.GET)
    public ResponseEntity<Status> getsave(@RequestParam int ie_id){
           Status status=new Status();
           List<PropadEmpProfDetails> list=empProfRepository.findByIe_id(ie_id);
          // List<RtSavedJobDetails> list = savedRepository.findBySjEmployeeCodeAndRtJobDetails_JdPositionCode(sjEmployeeCode, jdPositionCode);
             if(!list.isEmpty()&& list.size()>0) 
             { 
                    status.setStatusCode(200);
                    status.setPropadEmpProfDetails(list.get(0));
             }
           return new ResponseEntity<Status>(status, HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/upload-prof-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpProfDetails uploaddocumentModel( @RequestPart(required = false) Map<String, String> json, EmployeeProfDTO empProf, @RequestParam("file") MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4, @RequestParam(required = false) MultipartFile file5) throws IOException, SerialException, SQLException {
		System.out.println("test"+file.getOriginalFilename());
		System.out.println(file.getBytes());
//		System.out.println(emptech.getEt_tech_cert1());
		
		PropadEmpProfDetails ppd = new PropadEmpProfDetails();
//  pet.setEt_tech_cert1(((EmpTechDTO) file).getEt_tech_cert1());
//	pet.setEt_emp_id(et_emp_id);
		System.out.println("hiii from object");
		ppd.setEp_prof_mail(empProf.getEp_prof_mail());
		ppd.setIe_id(empProf.getIe_id());
		
		if(file!=null) {
			ppd.setEp_service_cert1(file.getBytes());
			  ppd.setService1_status("Submitted");
		} else
			ppd.setService1_status("Not Submitted");
		
			if(file1!=null) {
				ppd.setEp_service_cert2(file1.getBytes());
				ppd.setService2_status("Submitted");
			}else {
				ppd.setService2_status("Not Submitted");
			}
	        
	       
	        if(file2!=null) {
	        	ppd.setEp_service_cert3(file2.getBytes());
	        	 ppd.setService3_status("Submitted");
			}else {
				ppd.setService3_status("Not Submitted");
			}

	       
	        if(file3!=null) {
	        	ppd.setEp_payslip1(file3.getBytes());
	        	ppd.setPayslip1_status("Submitted");
	       }else {
	    	   ppd.setPayslip1_status("Not Submitted");
	    	   
	       }
	        if(file4!=null) {
	        	ppd.setEp_payslip2(file4.getBytes());
	        	ppd.setPayslip2_status("Submitted");
			}else {
				ppd.setPayslip2_status("Not Submitted");
			}
	        if(file5!=null) {
	        	ppd.setEp_payslip3(file5.getBytes());
	    		ppd.setPayslip3_status("Submitted");
			}else {
				ppd.setPayslip3_status("Not Submitted");
			}
	      

		ppd.setEp_service_cert2_text(empProf.getEp_service_cert2_text());
		
		ppd.setEp_service_cert3_text(empProf.getEp_service_cert3_text());
		
		ppd.setEp_payslip1_text(empProf.getEp_payslip1_text());
		
		ppd.setEp_payslip2_text(empProf.getEp_payslip2_text());
		
		ppd.setEp_payslip3_text(empProf.getEp_payslip3_text());
		
		return this.empProf.save(ppd) ;
	}

	@RequestMapping(value = "/update-prof-document", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public PropadEmpProfDetails updatedocumentModel( @RequestPart(required = false) Map<String, String> json, EmployeeProfDTO empProf, @RequestParam(required = false) MultipartFile file, @RequestParam(required = false) MultipartFile file1,@RequestParam(required = false) MultipartFile file2,@RequestParam(required = false) MultipartFile file3,@RequestParam(required = false) MultipartFile file4, @RequestParam(required = false) MultipartFile file5) throws IOException, SerialException, SQLException {
	System.out.println("hiii from function");

/////////////////updated details////////////////
	PropadEmpProfDetails pep3 = new PropadEmpProfDetails();
System.out.println("hiii from object");
pep3.setEp_id(empProf.getEp_id());
pep3.setIe_id(empProf.getIe_id());
pep3.setEp_prof_mail(empProf.getEp_prof_mail());
//pep3.setEp_prof_emp_id(empProf.getEp_prof_emp_id());
if(file!=null) {
pep3.setEp_service_cert1(file.getBytes());
pep3.setService1_status("Submitted");
}
if(file1!=null) {
pep3.setEp_service_cert2(file1.getBytes());
pep3.setService2_status("Submitted");
}
if(file2!=null) {
pep3.setEp_service_cert3(file2.getBytes());
pep3.setService3_status("Submitted");
}
if(file3!=null) {
pep3.setEp_payslip1(file3.getBytes());
pep3.setPayslip1_status("Submitted");
}
if(file4!=null) {
pep3.setEp_payslip2(file4.getBytes());
pep3.setPayslip2_status("Submitted");
}
if(file5!=null) {
pep3.setEp_payslip3(file5.getBytes());
pep3.setPayslip3_status("Submitted");
}

System.out.println("updarteed records"+pep3);


PropadEmpProfDetails returnrecord=null;
if( pep3.getEp_id()!=0)	{
	PropadEmpProfDetails pep2 = empProfRepository.getOne(pep3.getEp_id());
System.out.println("record in database"+pep2);
if (pep2.getIe_id() == pep3.getIe_id()) {
	PropadEmpProfDetails pep = new PropadEmpProfDetails();
pep.setEp_id(pep2.getEp_id());
pep.setIe_id(pep2.getIe_id());
pep.setEp_prof_mail(pep2.getEp_prof_mail());
if(pep3.getEp_service_cert1()!=null) {
 pep.setEp_service_cert1(pep3.getEp_service_cert1());
 pep.setService1_status("Submitted");
}else
{
 pep.setEp_service_cert1(pep2.getEp_service_cert1());
 pep.setService1_status(pep2.getService1_status());
}
if(pep3.getEp_service_cert2()!=null) {
	 pep.setEp_service_cert2(pep3.getEp_service_cert2());
	 pep.setService2_status("Submitted");
	}else
	{
	 pep.setEp_service_cert2(pep2.getEp_service_cert2());
	 pep.setService2_status(pep2.getService2_status());
	}
if(pep3.getEp_service_cert3()!=null) {
	 pep.setEp_service_cert3(pep3.getEp_service_cert3());
	 pep.setService3_status("Submitted");
	}else
	{
	 pep.setEp_service_cert3(pep2.getEp_service_cert3());
	 pep.setService3_status(pep2.getService3_status());
	}
if(pep3.getEp_payslip1()!=null) {
	 pep.setEp_payslip1(pep3.getEp_payslip1());
	 pep.setPayslip1_status("Submitted");
	}else
	{
	 pep.setEp_payslip1(pep2.getEp_payslip1());
	 pep.setPayslip1_status(pep2.getPayslip1_status());
	}
if(pep3.getEp_payslip2()!=null) {
	 pep.setEp_payslip2(pep3.getEp_payslip2());
	 pep.setPayslip2_status("Submitted");
	}else
	{
	 pep.setEp_payslip2(pep2.getEp_payslip2());
	 pep.setPayslip2_status(pep2.getPayslip2_status());
	}
if(pep3.getEp_payslip3()!=null) {
	 pep.setEp_payslip3(pep3.getEp_payslip3());
	 pep.setPayslip3_status("Submitted");
	}else
	{
	 pep.setEp_payslip3(pep2.getEp_payslip3());
	 pep.setPayslip3_status(pep2.getPayslip3_status());
	}






System.out.println("update of record needed");
returnrecord=pep;
System.out.println("updation done successfully");
//returnrecord=this.empTech.save(pet);


}
else
{
returnrecord=pep3;
//returnrecord=	 this.empTech.save(pet3);
}
}
return this.empProf.save(returnrecord);
}

	
	@RequestMapping(value = "/update-prof-status", method = RequestMethod.POST)
	public PropadEmpProfDetails updatedocumentstatus( @RequestBody EmployeeProfDTO empProf) throws IOException, SerialException, SQLException {
		System.out.println("hiii from function");
		/////////////////updated details////////////////
		PropadEmpProfDetails ppd3 = new PropadEmpProfDetails();
		System.out.println("hiii from object");
		ppd3.setEp_id(empProf.getEp_id());
		ppd3.setIe_id(empProf.getIe_id());
		ppd3.setEp_prof_mail(empProf.getEp_prof_mail());
		ppd3.setService1_status(empProf.getService1_status());
		ppd3.setService2_status(empProf.getService2_status());
		ppd3.setService3_status(empProf.getService3_status());
		ppd3.setPayslip1_status(empProf.getPayslip1_status());
		ppd3.setPayslip2_status(empProf.getPayslip2_status());
		ppd3.setPayslip3_status(empProf.getPayslip3_status());
		
		
		System.out.println("updarteed records"+ppd3);
		
		
		PropadEmpProfDetails returnrecord=null;
	if( ppd3.getEp_prof_mail()!=null)	{
//		PropadEmpProfDetails ppd2 = empProfRepository.getOneRow(ppd3.getEp_prof_mail());
		PropadEmpProfDetails ppd2 = empProfRepository.getOne(ppd3.getEp_id());
		System.out.println("record in database"+ppd2);
		
		 if(ppd2.getIe_id()==ppd3.getIe_id()){
			 PropadEmpProfDetails ppd = new PropadEmpProfDetails();
			 ppd.setEp_id(ppd2.getEp_id());
			 ppd.setIe_id(ppd2.getIe_id());
			 
			 ppd.setEp_service_cert1(ppd2.getEp_service_cert1());
			 ppd.setEp_service_cert2(ppd2.getEp_service_cert2());
			 ppd.setEp_service_cert3(ppd2.getEp_service_cert3());
			 ppd.setEp_payslip1(ppd2.getEp_payslip1());
			 ppd.setEp_payslip2(ppd2.getEp_payslip2());
			 ppd.setEp_payslip3(ppd2.getEp_payslip3());
			 ppd.setEp_prof_mail(ppd2.getEp_prof_mail());
			 
			 ppd.setService1_status(ppd3.getService1_status());
			 ppd.setService2_status(ppd3.getService2_status());
			 ppd.setService3_status(ppd3.getService3_status());
			 ppd.setPayslip1_status(ppd3.getPayslip1_status());
			 ppd.setPayslip2_status(ppd3.getPayslip2_status());
			 ppd.setPayslip3_status(ppd3.getPayslip3_status());
			 
			
			 
		 System.out.println("update of record needed");
		 returnrecord=ppd;
		 System.out.println("updation done successfully");
	 }
		 else
		 {
			 returnrecord=ppd3;
		 }
	}
	return this.empProf.save(returnrecord);
	}
	
	@RequestMapping(value = "/upload-prof-camera", method = RequestMethod.POST)
	public PropadEmpProfDetails uploaddocumentcamera( @RequestBody EmployeeProfDTO empProf){
		PropadEmpProfDetails ppd = new PropadEmpProfDetails();
		System.out.println("hiii from object");
		ppd.setEp_prof_mail(empProf.getEp_prof_mail());
		ppd.setIe_id(empProf.getIe_id());
		
		if(empProf.getEp_service_cert1()!=null) {
			ppd.setEp_service_cert1(empProf.getEp_service_cert1());
			  ppd.setService1_status("Submitted");
		} else
			ppd.setService1_status("Not Submitted");
		
			if(empProf.getEp_service_cert2()!=null) {
				ppd.setEp_service_cert2(empProf.getEp_service_cert2());
				ppd.setService2_status("Submitted");
			}else {
				ppd.setService2_status("Not Submitted");
			}
	        
	       
	        if(empProf.getEp_service_cert3()!=null) {
	        	ppd.setEp_service_cert3(empProf.getEp_service_cert3());
	        	 ppd.setService3_status("Submitted");
			}else {
				ppd.setService3_status("Not Submitted");
			}

	       
	        if(empProf.getEp_payslip1()!=null) {
	        	ppd.setEp_payslip1(empProf.getEp_payslip1());
	        	ppd.setPayslip1_status("Submitted");
	       }else {
	    	   ppd.setPayslip1_status("Not Submitted");
	    	   
	       }
	        if(empProf.getEp_payslip2()!=null) {
	        	ppd.setEp_payslip2(empProf.getEp_payslip2());
	        	ppd.setPayslip2_status("Submitted");
			}else {
				ppd.setPayslip2_status("Not Submitted");
			}
	        if(empProf.getEp_payslip3()!=null) {
	        	ppd.setEp_payslip3(empProf.getEp_payslip3());
	    		ppd.setPayslip3_status("Submitted");
			}else {
				ppd.setPayslip3_status("Not Submitted");
			}
	      

	
		
		return this.empProf.save(ppd) ;
	}

	@RequestMapping(value = "/update-prof-camera", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PropadEmpProfDetails updatedocumentcamera( @RequestBody EmployeeProfDTO empProf) {
	System.out.println("hiii from function");

/////////////////updated details////////////////
	PropadEmpProfDetails pep3 = new PropadEmpProfDetails();
System.out.println("hiii from object");
pep3.setEp_id(empProf.getEp_id());
pep3.setIe_id(empProf.getIe_id());
pep3.setEp_prof_mail(empProf.getEp_prof_mail());
//pep3.setEp_prof_emp_id(empProf.getEp_prof_emp_id());
if(empProf.getEp_service_cert1()!=null) {
pep3.setEp_service_cert1(empProf.getEp_service_cert1());
pep3.setService1_status("Submitted");
}
if(empProf.getEp_service_cert2()!=null) {
pep3.setEp_service_cert2(empProf.getEp_service_cert2());
pep3.setService2_status("Submitted");
}
if(empProf.getEp_service_cert3()!=null) {
pep3.setEp_service_cert3(empProf.getEp_service_cert3());
pep3.setService3_status("Submitted");
}
if(empProf.getEp_payslip1()!=null) {
pep3.setEp_payslip1(empProf.getEp_payslip1());
pep3.setPayslip1_status("Submitted");
}
if(empProf.getEp_payslip2()!=null) {
pep3.setEp_payslip2(empProf.getEp_payslip2());
pep3.setPayslip2_status("Submitted");
}
if(empProf.getEp_payslip3()!=null) {
pep3.setEp_payslip3(empProf.getEp_payslip3());
pep3.setPayslip3_status("Submitted");
}

System.out.println("updarteed records"+pep3);


PropadEmpProfDetails returnrecord=null;
if( pep3.getEp_id()!=0)	{
	PropadEmpProfDetails pep2 = empProfRepository.getOne(pep3.getEp_id());
System.out.println("record in database"+pep2);
if (pep2.getIe_id() == pep3.getIe_id()) {
	PropadEmpProfDetails pep = new PropadEmpProfDetails();
pep.setEp_id(pep2.getEp_id());
pep.setIe_id(pep2.getIe_id());
pep.setEp_prof_mail(pep2.getEp_prof_mail());
if(pep3.getEp_service_cert1()!=null) {
 pep.setEp_service_cert1(pep3.getEp_service_cert1());
 pep.setService1_status("Submitted");
}else
{
 pep.setEp_service_cert1(pep2.getEp_service_cert1());
 pep.setService1_status(pep2.getService1_status());
}
if(pep3.getEp_service_cert2()!=null) {
	 pep.setEp_service_cert2(pep3.getEp_service_cert2());
	 pep.setService2_status("Submitted");
	}else
	{
	 pep.setEp_service_cert2(pep2.getEp_service_cert2());
	 pep.setService2_status(pep2.getService2_status());
	}
if(pep3.getEp_service_cert3()!=null) {
	 pep.setEp_service_cert3(pep3.getEp_service_cert3());
	 pep.setService3_status("Submitted");
	}else
	{
	 pep.setEp_service_cert3(pep2.getEp_service_cert3());
	 pep.setService3_status(pep2.getService3_status());
	}
if(pep3.getEp_payslip1()!=null) {
	 pep.setEp_payslip1(pep3.getEp_payslip1());
	 pep.setPayslip1_status("Submitted");
	}else
	{
	 pep.setEp_payslip1(pep2.getEp_payslip1());
	 pep.setPayslip1_status(pep2.getPayslip1_status());
	}
if(pep3.getEp_payslip2()!=null) {
	 pep.setEp_payslip2(pep3.getEp_payslip2());
	 pep.setPayslip2_status("Submitted");
	}else
	{
	 pep.setEp_payslip2(pep2.getEp_payslip2());
	 pep.setPayslip2_status(pep2.getPayslip2_status());
	}
if(pep3.getEp_payslip3()!=null) {
	 pep.setEp_payslip3(pep3.getEp_payslip3());
	 pep.setPayslip3_status("Submitted");
	}else
	{
	 pep.setEp_payslip3(pep2.getEp_payslip3());
	 pep.setPayslip3_status(pep2.getPayslip3_status());
	}


System.out.println("update of record needed");
returnrecord=pep;
System.out.println("updation done successfully");

}
else
{
returnrecord=pep3;
}
}
return this.empProf.save(returnrecord);
}
	
//	@RequestMapping(value = "/uploads", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<Object> uploadFile( @RequestPart(required = false) Map<String, String> json, EmployeeProfDTO empProf,@RequestParam(required= false) MultipartFile file) throws IOException {
//		System.out.println("Srijithcode");
////		File convertFile = new File("D:\\Srijith1\\" + file.getOriginalFilename());
//		
//        try {
//            File files = new File(this.storagePath + empProf.getIe_id());
//if (!files.exists()) 
//{
//if (files.mkdirs()) 
//  {
//   System.out.println("Multiple directories are created!");
//   
//  }
//else    {
//System.out.println("Failed to create multiple directories!");      
//}
//            File convertFile= new File(this.storagePath + empProf.getIe_id()+ File.separator +file.getOriginalFilename());
//            convertFile.createNewFile();
//            FileOutputStream fout=new FileOutputStream(convertFile);
//            fout.write(file.getBytes());
//            fout.close();
//            File convertFile1= new File(this.storagePath + empProf.getIe_id()+ File.separator +file.getOriginalFilename());
//            System.out.println(convertFile1);
//            
//          convertFile1.createNewFile();
//          FileOutputStream fout1=new FileOutputStream(convertFile1);
//          fout1.write(file.getBytes());
//          fout1.close();
//
//          
//            
//}
//else {
//
//
//}
//
//
//}
//catch (NoSuchFileException  e) {
//            e.printStackTrace();
//}
//
//File convertFile= new File(this.storagePath + empProf.getIe_id()+ File.separator +file.getOriginalFilename());
//		
//		System.out.println(this.storagePath + empProf.getIe_id()+ File.separator +file.getOriginalFilename());
//		convertFile.createNewFile();
////		file.getOriginalFilename();
//		FileOutputStream fout = new FileOutputStream(convertFile);
//		fout.write(file.getBytes());
//		fout.close();
//		return new ResponseEntity<>("File uploaded Successfully", HttpStatus.OK);
//		
//	}  
 

//    @RequestMapping(value="/uploads1",method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<Object> uploadFile3(@RequestParam("file") MultipartFile file, @RequestPart(required = false) Map<String, String> json, EmployeeProfDTO empProf) throws IOException{
//                    
//                byte[] bytes = file.getBytes();
//                Path path = Paths.get(storagePath  +file.getOriginalFilename());
//                path.toAbsolutePath();
//                Path pathDir = Paths.get(storagePath +File.separator+empProf.getIe_id()+File.separator+file.getOriginalFilename());
//                    try {
//                                    File files = new File(this.storagePath + empProf.getIe_id());
//                                    System.out.println("Banu "+files);
//                                    
//            if (!files.exists()) 
//            {
//                if (files.mkdirs()) 
//                          {
//                           System.out.println("Multiple directories are created!");
//                           
//                          }
//                else    {
//                        System.out.println("Failed to create multiple directories!");      
//                        }
//                           
//                                    
//                                    File convertFile1= new File(this.storagePath + empProf.getIe_id()+ File.separator +file.getOriginalFilename());
//                                      System.out.println(convertFile1);
//                                      
//                                    convertFile1.createNewFile();
//                                    FileOutputStream fout1=new FileOutputStream(convertFile1);
//                                    fout1.write(file.getBytes());
//                                    fout1.close();
//            }
//            else {
//            	System.out.println("folder already exists");
//            	System.out.println("path "+pathDir);
//                Files.write(pathDir, bytes);
//                    
//            }
//           
//                    
//                    }
//                    catch (NoSuchFileException e) {
//                                    e.printStackTrace();
//                    }
//                      
//                    return new ResponseEntity<>("File converted Successfully",HttpStatus.OK) ;
//    }

        
}


