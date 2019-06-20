package com.prodapt.propad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.MediclaimForm;


@Repository

	public interface MediclaimRepository extends JpaRepository<MediclaimForm, Integer>{

	@Query(value="select * from mediclaim_form where ie_id=?1", nativeQuery = true)
	public  List<MediclaimForm> findByIe_id(int  ie_id);
	
	

}
