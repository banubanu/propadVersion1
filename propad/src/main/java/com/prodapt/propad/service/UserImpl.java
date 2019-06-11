package com.prodapt.propad.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadUsers;
import com.prodapt.propad.repository.ServiceRepository;
import com.prodapt.propad.repository.UserRepository;

@Service
public class UserImpl implements User {
UserRepository userRepository;

public UserImpl(UserRepository userRepository) {
	// TODO Auto-generated constructor stub
	this.userRepository = userRepository;
}
	@Override
	public List<PropadUsers> getAll() {
		// TODO Auto-generated method stub
		return this.userRepository.findAll();
	}

	@Override
	public PropadUsers save(PropadUsers pu) {
		// TODO Auto-generated method stub
		return this.userRepository.save(pu);
	}
	@Override
	public List<PropadUsers> findByUserEmailAndUserPassword(String user_email,String user_password) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUserEmailAndUserPassword(user_email,user_password);
	}
	@Override
	public List<PropadUsers> findByUserPassword(String user_password) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUserPassword(user_password);
	}

}
