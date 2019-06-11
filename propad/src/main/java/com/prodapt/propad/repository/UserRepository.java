package com.prodapt.propad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadUsers;

@Repository
public interface UserRepository  extends JpaRepository<PropadUsers, Integer>{

//	Integer findByUserEmailAndUserPassword(String user_email, String user_password);

	
	@Query(value="select * from propad_users where user_email=?1 and user_password=?2", nativeQuery = true)
	public List<PropadUsers> findByUserEmailAndUserPassword(String user_email,String user_password);

	@Query(value="select * from propad_users where user_password=?1", nativeQuery = true)
	public List<PropadUsers> findByUserPassword(String user_password);
	
}
