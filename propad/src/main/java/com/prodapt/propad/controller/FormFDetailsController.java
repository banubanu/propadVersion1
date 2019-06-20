package com.prodapt.propad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.propad.dto.FormFDetailsDTO;
import com.prodapt.propad.model.FormFDetailsModel;
import com.prodapt.propad.service.FormFDetails;


@RestController
@CrossOrigin("*")

@RequestMapping("/addDetails")
public class FormFDetailsController {
	
	@Autowired
	FormFDetails formfdetails ;
//	@PostMapping("/saveWitness")
//	public FormFWitnessModel addWitnessDetailsDemo(@RequestBody FormFWitnessDetailsDTO witness) {
//			return formfwitness.saveDemo(witness);
//	}
//	
	
	@PostMapping("/saveDetails")
	public FormFDetailsModel addDetails(@RequestBody FormFDetailsDTO details)
	{
		return formfdetails.save(details);
	}

	@GetMapping("fetchDetails")
	public String fetchDetails(@RequestParam (value="ie_id") int ieId)
	{
		return formfdetails.fetchDetails(ieId);
	}

}
