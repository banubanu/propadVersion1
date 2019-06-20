package com.prodapt.propad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prodapt.propad.model.MediclaimForm;

import com.prodapt.propad.repository.MediclaimRepository;

@Service
public class MediclaimImp implements Mediclaim {

	MediclaimRepository mediclaimrepo;
	
	
	public MediclaimImp(MediclaimRepository mediclaimrepo) {
		// TODO Auto-generated constructor stub
		this.mediclaimrepo = mediclaimrepo;
	}
	
	@Override
	public List<MediclaimForm> getByIe_id(int ie_id) {
		
		return mediclaimrepo.findByIe_id(ie_id);
	}

	@Override
	public MediclaimForm save(MediclaimForm returnrecord) {
		// TODO Auto-generated method stub
		return mediclaimrepo.save(returnrecord);
	}

}
