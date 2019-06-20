package com.prodapt.propad.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.dozer.DozerBeanMapper;
import com.prodapt.propad.dto.CompanyApplicationDTO;
import com.prodapt.propad.model.CompanyApplicationForm;
import com.prodapt.propad.repository.CompanyApplicationRepository;



@Service
public class CompanyAppImpl  implements CompanyApp {

CompanyApplicationRepository comAppRepo;
	
	
	public CompanyAppImpl(CompanyApplicationRepository comAppRepo) {
		// TODO Auto-generated constructor stub
		this.comAppRepo = comAppRepo;
	}
	
	@Override
	public List<CompanyApplicationForm> getByIe_id(int ie_id) {
		
		return comAppRepo.findByIe_id(ie_id);
	}

	@Override
	public CompanyApplicationForm saveDemo(CompanyApplicationDTO companyapp) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		CompanyApplicationForm caf =  mapper.map(companyapp, CompanyApplicationForm.class);
		return comAppRepo.save(caf);
	}

	@Override
	public CompanyApplicationForm save(CompanyApplicationForm caf) {
		// TODO Auto-generated method stub
		return comAppRepo.save(caf);
	}
	

}