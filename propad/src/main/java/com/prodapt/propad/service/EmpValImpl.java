package com.prodapt.propad.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.prodapt.propad.model.PropadEmpValidation;
import com.prodapt.propad.repository.EmpValRepository;


@Service
public class EmpValImpl implements EmpVal {
	EmpValRepository service;
	
	public EmpValImpl(EmpValRepository service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@Override
	public List<PropadEmpValidation> getAll() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	@Override
	public PropadEmpValidation save(PropadEmpValidation pvd) {
		// TODO Auto-generated method stub
		return service.save(pvd);
	}


}
