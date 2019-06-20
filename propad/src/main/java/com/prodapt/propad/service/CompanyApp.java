package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.dto.CompanyApplicationDTO;
import com.prodapt.propad.model.CompanyApplicationForm;

public interface CompanyApp {

	

	List<CompanyApplicationForm> getByIe_id(int ie_id);

	CompanyApplicationForm save(CompanyApplicationForm idc);

	CompanyApplicationForm saveDemo(CompanyApplicationDTO companyapp);

}

