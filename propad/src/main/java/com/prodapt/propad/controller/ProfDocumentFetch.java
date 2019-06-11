package com.prodapt.propad.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadEmpProfDetails;
import com.prodapt.propad.model.Status;
import com.prodapt.propad.repository.EmpProfRepository;
import com.prodapt.propad.service.EmpProf;


@RestController
@CrossOrigin("*")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@RequestMapping("/getprofdocument")
public class ProfDocumentFetch {
	@Autowired
	EmpProf empProf;
	
	@PersistenceContext
    EntityManager entityManager;
	
	public ProfDocumentFetch(EmpProf empProf) {
		// TODO Auto-generated constructor stub
		this.empProf = empProf;
	}
	
    
	
	@RequestMapping(value = "/get-prof-documents", method = RequestMethod.GET)
	public List<PropadEmpProfDetails> getUsers(@RequestParam("ie_id") int ie_id) {
		System.out.println("in get");
		return this.empProf.getByIe_id(ie_id);
}
	
	@GetMapping("get-pending-documents")
    public List<PropadEmpProfDetails> getPendingDocument(@RequestParam("ie_id") int ie_id) {
           Query query = entityManager.createNativeQuery(
                        "select service1_status,sevice2_status,service3_status,payslip1_status,payslip2_status,payslip3_status from propad_emp_prof_details where ie_id='"+ie_id+"'");
           List<PropadEmpProfDetails> pendingDocuments = query.getResultList();
           return pendingDocuments;

    }
	
}
