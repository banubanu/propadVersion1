package com.prodapt.propad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.IdCardForm;




	
	@Repository

	public interface IdcardRepository extends JpaRepository<IdCardForm, Integer>{

	@Query(value="select * from idcard_form where ie_id=?1", nativeQuery = true)
	public  List<IdCardForm> findByIe_id(int  ie_id);
	
	

}


