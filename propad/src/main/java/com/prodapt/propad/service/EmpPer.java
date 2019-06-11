package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;

public interface EmpPer {
	
	List<PropadEmpPerDetails> getAll();
	List<PropadEmpPerDetails> getOneRow(String ep_per_mail);
	Integer countnull(int ie_id);
	PropadEmpPerDetails save(PropadEmpPerDetails  pep);
	List<PropadEmpPerDetails> findByEp_per_mail(String ep_per_mail);
	List<PropadEmpPerDetails> findByIe_id(int ie_id);
	
	
	
	

}
