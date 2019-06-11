package com.prodapt.propad.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.service.EmpTech;


@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/gettechdocument")
public class TechicalDocumentFetch {

	
	@Autowired
	EmpTech empTech;
	
	@PersistenceContext
    EntityManager entityManager;
	
	public TechicalDocumentFetch(EmpTech empTech) {
		// TODO Auto-generated constructor stub
		this.empTech = empTech;
	}
	
	
	@RequestMapping(value = "/get-all-documents", method = RequestMethod.GET)
	public List<PropadEmpTechDetails> getUsers(@RequestParam("ie_id") int ie_id) {
		System.out.println("in get");
		return this.empTech.getByIe_id(ie_id);
	}
	
	
	@GetMapping("get-pending-documents")
    public List<PropadEmpTechDetails> getPendingDocument(@RequestParam("ie_id") int ie_id) {
           Query query = entityManager.createNativeQuery(
                        "select tech1_status,tech2_status,tech3_status,tech4_status,tech5_status from propad_emp_tech_details where ie_id='"+ie_id+"'");
           List<PropadEmpTechDetails> pendingDocuments = query.getResultList();
           return pendingDocuments;

    }
	
	
	


	
}









	
	
