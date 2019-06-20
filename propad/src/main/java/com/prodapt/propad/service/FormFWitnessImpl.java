package com.prodapt.propad.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prodapt.propad.dto.FormFEmployeeDTO;
import com.prodapt.propad.dto.FormFEmployerDTO;
import com.prodapt.propad.dto.FormFNomineeDetailsDTO;
import com.prodapt.propad.dto.FormFWitnessDetailsDTO;
import com.prodapt.propad.model.FormFEmployeeModel;
import com.prodapt.propad.model.FormFEmployerModel;
import com.prodapt.propad.model.FormFNomineeModel;
import com.prodapt.propad.model.FormFWitnessModel;
import com.prodapt.propad.repository.FormFEmployeeRepository;
import com.prodapt.propad.repository.FormFEmployerRepository;
import com.prodapt.propad.repository.FormFNomineeRepository;
import com.prodapt.propad.repository.FormFWitnessRepository;

@Service
public class FormFWitnessImpl implements FormFWitness {

	@Autowired
	FormFWitnessRepository formFwitnessRepository;

	@Autowired
	FormFNomineeRepository formfnomineerepository;

	@Autowired
	FormFEmployeeRepository formfemployeerepository;

	@Autowired
	FormFEmployerRepository formfemployerrepository;

	@Override
	public List<FormFWitnessModel> getAll() {
		return formFwitnessRepository.findAll();
	}

	@Override
	public FormFWitnessModel saveDemo(FormFWitnessDetailsDTO witness) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		FormFWitnessModel fw = mapper.map(witness, FormFWitnessModel.class);
		return formFwitnessRepository.save(fw);
	}

	@Override
	public List<FormFNomineeModel> getNom() {
		// TODO Auto-generated method stub
		return formfnomineerepository.findAll();
	}

	@Override
	public List<FormFNomineeModel> saveNominee(List<FormFNomineeDetailsDTO> nom) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		List<FormFNomineeModel> formFNominees =  new ArrayList<>();
		for (FormFNomineeDetailsDTO formFNomineeDetailsDTO : nom) {
			formFNominees.add(mapper.map(formFNomineeDetailsDTO, FormFNomineeModel.class));
		}
		return formfnomineerepository.saveAll(formFNominees);
	}

	@Override
	public List<FormFEmployeeModel> getStat() {

		return formfemployeerepository.findAll();
	}

	@Override
	public FormFEmployeeModel saveStatement(FormFEmployeeDTO stat) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		FormFEmployeeModel aa = mapper.map(stat, FormFEmployeeModel.class);
		return formfemployeerepository.save(aa);
	}

	@Override
	public FormFEmployerModel saveEmployer(FormFEmployerDTO employ) {
		DozerBeanMapper mapper = new DozerBeanMapper();
		FormFEmployerModel aa = mapper.map(employ, FormFEmployerModel.class);
		return formfemployerrepository.save(aa);
	}

	@Override
	public String fetchWitnessDetails(FormFWitnessDetailsDTO formFWitnessDetailsDTO) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(formFwitnessRepository.findAll());
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String fetchWitnessDetailsByWitnessId(int ieId) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return  mapper.writeValueAsString(formFwitnessRepository.find(ieId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String fetchNomineeDetails(int ieId) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return  mapper.writeValueAsString(formfnomineerepository.find(ieId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String fetchEmployeeDetails(int ieId) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return  mapper.writeValueAsString(formfemployeerepository.find(ieId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String fetchEmployerDetails(int ieId) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return  mapper.writeValueAsString(formfemployerrepository.find(ieId));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	
//	@Override
//	public String fetchNomineeDetails(int nomineeId) {
//		ObjectMapper mapper = new ObjectMapper();
//		try
//		{
//			return mapper.writeValueAsString(formfnomineerepository.find(nomineeId));
//		}
//		catch(JsonProcessingException e)
//		{
//			e.printStackTrace();
//		}
//		return null;
//	}


}
