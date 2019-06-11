package com.prodapt.propad.service;

import java.util.List;

import org.springframework.stereotype.Service;


import com.prodapt.propad.model.PropadEmpProfDetails;
import com.prodapt.propad.model.PropadEmpTechDetails;
import com.prodapt.propad.repository.EmpProfRepository;


@Service
public class EmpProfImpl implements EmpProf {
	EmpProfRepository service;
	
	public EmpProfImpl(EmpProfRepository service) {
		// TODO Auto-generated constructor stub
		this.service = service;
	}
	
	@Override
	public List<PropadEmpProfDetails> getAll() {
		// TODO Auto-generated method stub
		return service.findAll();
	}

	
	@Override
	public List<PropadEmpProfDetails> getOneRow(String ep_prof_mail) {
		// TODO Auto-generated method stub
		return (List<PropadEmpProfDetails>) service.getOneRow(ep_prof_mail);
	}
	@Override
	public PropadEmpProfDetails save(PropadEmpProfDetails ppd) {
		// TODO Auto-generated method stub
		return service.save(ppd);
	}

	@Override
	public Integer countnull(int ie_id) {
		// TODO Auto-generated method stub
		return service.countnull(ie_id);
	}

	@Override
	public List<PropadEmpProfDetails> getByEp_prof_mail(String ep_prof_mail) {
		// TODO Auto-generated method stub
		return service.findByEp_prof_mail(ep_prof_mail);
	}

	@Override
	public List<PropadEmpProfDetails> getByIe_id(int ie_id) {
		// TODO Auto-generated method stub
		return service.findByIe_id(ie_id);
	}


	

}
