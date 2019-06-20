package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.dto.FormFEmployeeDTO;
import com.prodapt.propad.dto.FormFEmployerDTO;
import com.prodapt.propad.dto.FormFNomineeDetailsDTO;
import com.prodapt.propad.dto.FormFWitnessDetailsDTO;
import com.prodapt.propad.model.FormFEmployeeModel;
import com.prodapt.propad.model.FormFEmployerModel;
import com.prodapt.propad.model.FormFNomineeModel;
import com.prodapt.propad.model.FormFWitnessModel;

public interface FormFWitness {

	List<FormFWitnessModel> getAll();
	FormFWitnessModel saveDemo(FormFWitnessDetailsDTO witness);
	
	List<FormFNomineeModel> getNom();
	List<FormFNomineeModel> saveNominee(List<FormFNomineeDetailsDTO> nom);
	
	List<FormFEmployeeModel> getStat();
	FormFEmployeeModel saveStatement(FormFEmployeeDTO stat);
	
	//List<FormFEmployerModel>  
	FormFEmployerModel saveEmployer(FormFEmployerDTO employ);
	
	/**
	 * Fetch witness details.
	 *
	 * @param formFWitnessDetailsDTO the form F witness details DTO
	 * @return the string
	 */
	String fetchWitnessDetails(FormFWitnessDetailsDTO formFWitnessDetailsDTO);
	
	//crtl + alt + j 
	/**
	 * Fetch witness details by witness id.
	 *
	 * @param witnessId the witness id
	 * @return the string
	 */
	String fetchWitnessDetailsByWitnessId(int ieId);
	String fetchNomineeDetails(int ieId);
	String fetchEmployeeDetails(int ieId);
	String fetchEmployerDetails(int ieId);
	
	/**
	 * Fetch nominee details.
	 *
	 * @param formNomineeDetailsDTO the form F nominee details DTO
	 * @return the string
	 */
//	String fetchNomineeDetails(FormFNomineeDetailsDTO formNomineeDetailsDTO);
//	
//	String fetchEmployeeDetails(FormFEmployeeDTO formFEmployeeDTO);
//	String fetchEmployerDetails(FormFEmployerDTO formFEmployerDTO);
	
	
	
	
}
