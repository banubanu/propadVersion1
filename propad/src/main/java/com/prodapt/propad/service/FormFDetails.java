package com.prodapt.propad.service;





import java.util.List;

import com.prodapt.propad.dto.FormFDetailsDTO;
import com.prodapt.propad.model.FormFDetailsModel;



public interface FormFDetails {

	FormFDetailsModel save(FormFDetailsDTO fw);

	List<FormFDetailsModel> getAll();

	String fetchDetails(int ieId);

	
}
