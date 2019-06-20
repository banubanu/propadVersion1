package com.prodapt.propad.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.propad.dto.FormFEmployeeDTO;
import com.prodapt.propad.dto.FormFEmployerDTO;
import com.prodapt.propad.dto.FormFNomineeDetailsDTO;
import com.prodapt.propad.dto.FormFWitnessDetailsDTO;
import com.prodapt.propad.model.FormFEmployeeModel;
import com.prodapt.propad.model.FormFEmployerModel;
import com.prodapt.propad.model.FormFNomineeModel;
import com.prodapt.propad.model.FormFWitnessModel;

import com.prodapt.propad.service.FormFWitness;

@RestController
@CrossOrigin("*")

@RequestMapping("/add")
//witness
public class FormFWitnessController {
	@Autowired
	FormFWitness formfwitness;
	

	
	//@Autowired
	//FormFWitnessRepository formfwitnessrepository;
	
//	public FormFWitnessController(FormFWitness formfwitness) {
//		// TODO Auto-generated constructor stub
//		this.formfwitness = formfwitness;
//	}


	//@PostMapping("/saveWitness")
//	public FormFWitnessModel addWitnessDetails(@RequestBody FormFWitnessDetailsDTO witness) {
//		FormFWitnessModel fw = new FormFWitnessModel();
//		System.out.println("hiii from object test");
//				fw.setFf_witness_id(witness.getFf_witness_id());
//				fw.setFf_witness_name(witness.getFf_witness_name());
//				fw.setFf_witness_address(witness.getFf_witness_address());
//				fw.setFf_witness_place(witness.getFf_witness_place());
//				fw.setFf_witness_date(witness.getFf_witness_date());
//				fw.setIe_id(witness.getIe_id());
//			return this.formfwitness.save(fw);
//	}
	
	

	@PostMapping("/saveWitness")
	public FormFWitnessModel addWitnessDetailsDemo(@RequestBody FormFWitnessDetailsDTO witness) {
			return formfwitness.saveDemo(witness);
	}

	@PostMapping("/saveNominee")
	public List<FormFNomineeModel> addNominee(@RequestBody List<FormFNomineeDetailsDTO> nom) {
			return formfwitness.saveNominee(nom);
	}
	
	@PostMapping("/saveEmployee")
	public FormFEmployeeModel addStatement(@RequestBody FormFEmployeeDTO stat)
	{
		return formfwitness.saveStatement(stat);
	}
	
	@PostMapping("/saveEmployer")
	public FormFEmployerModel addEmployer(@RequestBody FormFEmployerDTO employ)
	{
		return formfwitness.saveEmployer(employ);
	}
	
//	@GetMapping("/witness-form-details")
//	public String fetchWitnessDetails(@RequestBody FormFWitnessDetailsDTO formFWitnessDetailsDTO) {
//		return formfwitness.fetchWitnessDetails(formFWitnessDetailsDTO);
//	}
//	
//	@GetMapping("/nominee-form-details") 
//	public String fetchNomineeDetails(@RequestBody FormFNomineeDetailsDTO formNomineeDetailsDTO)
//	{
//		return formfwitness.fetchNomineeDetails(formNomineeDetailsDTO);
//	}
//	
//	@GetMapping("/employee-form-details")
//	public String fetchEmployeeDetails(@RequestBody FormFEmployeeDTO formFEmployeeDTO)
//	{
//		return formfwitness.fetchEmployeeDetails(formFEmployeeDTO);
//	}
//	
//	@GetMapping("/employer-form-details")
//	public String fetchEmployerDetails(@RequestBody FormFEmployerDTO formFEmployerDTO)
//	{
//		return formfwitness.fetchEmployerDetails(formFEmployerDTO);
//	}
	@GetMapping("/witness-form-details-by-witnessId")
	public String fetchWitnessDetailsByWitnessId(@RequestParam (value="ie_id") int ieId) {
		return formfwitness.fetchWitnessDetailsByWitnessId(ieId);
	}
	@GetMapping("/nominee-form-details")
	public String fetchNomineeDetails(@RequestParam (value="ie_id") int ieId)
	{
		return formfwitness.fetchNomineeDetails(ieId);
	}
	@GetMapping("/employee-form-details")
	public String fetchEmployeeDetails(@RequestParam (value="ie_id") int ieId)
	{
		return formfwitness.fetchEmployeeDetails(ieId);
	}
	@GetMapping("employer-form-details")
	public String fetchEmployerDetails(@RequestParam (value="ie_id") int ieId)
	{
		return formfwitness.fetchEmployerDetails(ieId);
	}
	
	/**
//	 * Fetch nominee details.
//	 *
//	 * @param nomineeId the nominee id
//	 * @return the string
//	 */
//	@GetMapping("/nominee-form-details")
//	public String fetchNomineeDetails(@RequestBody int nomineeId)
//	{
//		return formfwitness.fetchNomineeDetails(nomineeId);
//	}
	
	

	
}
