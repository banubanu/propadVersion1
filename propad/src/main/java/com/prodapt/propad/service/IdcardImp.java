package com.prodapt.propad.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.prodapt.propad.model.IdCardForm;
import com.prodapt.propad.repository.IdcardRepository;




@Service
public class IdcardImp implements Idcard {

	IdcardRepository idcardrepo;
	
	
	public IdcardImp(IdcardRepository idcardrepo) {
		// TODO Auto-generated constructor stub
		this.idcardrepo = idcardrepo;
	}
	
	@Override
	public List<IdCardForm> getByIe_id(int ie_id) {
		
		return idcardrepo.findByIe_id(ie_id);
	}

	@Override
	public IdCardForm save(IdCardForm idc) {
		// TODO Auto-generated method stub
		return idcardrepo.save(idc);
	}



}
