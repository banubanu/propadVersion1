package com.prodapt.propad.service;
import java.util.List;


import com.prodapt.propad.model.PropadEmpTechDetails;

public interface EmpTech {

	Integer countnull(int ie_id);
	List<PropadEmpTechDetails> getOneRow(String et_emp_mail);
	List<PropadEmpTechDetails> getAll();
	PropadEmpTechDetails save(PropadEmpTechDetails  pet);
	PropadEmpTechDetails update(PropadEmpTechDetails  pet);
	List<PropadEmpTechDetails> getByEt_emp_mail(String et_emp_mail);
	List<PropadEmpTechDetails> getByIe_id(int ie_id);

}






