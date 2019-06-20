
package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.IdCardForm;
import com.prodapt.propad.model.MediclaimForm;

public interface Idcard {

	

	List<IdCardForm> getByIe_id(int ie_id);

	IdCardForm save(IdCardForm idc);

}



