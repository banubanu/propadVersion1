package com.prodapt.propad.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prodapt.propad.dto.FormFDetailsDTO;
import com.prodapt.propad.model.FormFDetailsModel;

import com.prodapt.propad.repository.FormFDetailsRepository;

@Service
public class FormFDetailsImpl implements FormFDetails {
	
	FormFDetailsRepository formfdetailsrepository;

	public FormFDetailsImpl(FormFDetailsRepository formfdetailsrepository)
	{
		this.formfdetailsrepository=formfdetailsrepository;
	}
	@Override
	public FormFDetailsModel save(FormFDetailsDTO details) {
		 DozerBeanMapper mapper = new DozerBeanMapper();
		 FormFDetailsModel fw =  mapper.map(details, FormFDetailsModel.class);
		return formfdetailsrepository.save(fw);
	}

	@Override
	public List<FormFDetailsModel> getAll() {
		// TODO Auto-generated method stub
		return formfdetailsrepository.findAll();
	}
	@Override
	public String fetchDetails(int ieId) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return  mapper.writeValueAsString(formfdetailsrepository.find(ieId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
//	
//	@Override
//	public String fetchEmployerDetails(int ieId) {
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			return  mapper.writeValueAsString(formfdetailsrepository.find(ieId));
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	
	

}
