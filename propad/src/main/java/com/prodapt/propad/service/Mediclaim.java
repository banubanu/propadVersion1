package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.MediclaimForm;

public interface Mediclaim {

	

	List<MediclaimForm> getByIe_id(int ie_id);

	MediclaimForm save(MediclaimForm returnrecord);

}






