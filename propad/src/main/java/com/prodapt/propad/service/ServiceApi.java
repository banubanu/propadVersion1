package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadInitiateEmployee;



public interface ServiceApi {
	List<PropadInitiateEmployee> getAll();
	PropadInitiateEmployee save(PropadInitiateEmployee  pie);
	List<PropadInitiateEmployee> getOneRow(String ie_emp_mail);
	List<PropadInitiateEmployee> getOne(int ie_emp_id);


}
