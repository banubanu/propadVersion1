package com.prodapt.propad.service;

import java.util.List;

import com.prodapt.propad.model.PropadUsers;


public interface User {
	List<PropadUsers> getAll();
	PropadUsers save(PropadUsers  pu);
	List<PropadUsers> findByUserPassword( String user_password);
	List<PropadUsers> findByUserEmailAndUserPassword(String user_email, String user_password);
}
