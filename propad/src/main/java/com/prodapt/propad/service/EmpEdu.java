package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadEmpEduDetails;


public interface EmpEdu {
	List<PropadEmpEduDetails> getAll();
	Integer countnull(int ie_id);
	PropadEmpEduDetails getOneRow(String ed_emp_mail);
	PropadEmpEduDetails save(PropadEmpEduDetails  pee);
	//List<PropadEmpEduDetails> findByEd_emp_mail(String ed_emp_mail);
	List<PropadEmpEduDetails[]> findPendingDocument(String ed_emp_mail);
	List<PropadEmpEduDetails> findByIe_id(int ie_id);
	List<PropadEmpEduDetails> findByEd_emp_mail(String ed_emp_mail);
	

}



