package com.prodapt.propad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.model.PropadInitiateEmployee;
import com.prodapt.propad.repository.ServiceRepository;


@Service
public class ServiceApiImpl implements ServiceApi {
ServiceRepository serviceRepository;
	
	public ServiceApiImpl(ServiceRepository serviceRepository) {
		// TODO Auto-generated constructor stub
		this.serviceRepository = serviceRepository;
	}
	
	@Override
	public List<PropadInitiateEmployee> getAll() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}

	@Override
	public PropadInitiateEmployee save(PropadInitiateEmployee pie) {
		// TODO Auto-generated method stub
		return serviceRepository.save(pie);
	}

	@Override
	public List<PropadInitiateEmployee> getOneRow(String ie_emp_mail) {
		// TODO Auto-generated method stub
		return  serviceRepository.getOneRow(ie_emp_mail);
	}
	
	@Override
	public List<PropadInitiateEmployee> getOne(int ie_emp_id) {
		// TODO Auto-generated method stub
		return  serviceRepository.getByEmpid(ie_emp_id);
	}
	
	

}








