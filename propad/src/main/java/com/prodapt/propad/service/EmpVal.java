package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadEmpValidation;



public interface EmpVal {
	List<PropadEmpValidation> getAll();
	PropadEmpValidation save(PropadEmpValidation  pvd);

}
