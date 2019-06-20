package com.prodapt.propad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.FormFDetailsModel;



@Repository
public interface FormFDetailsRepository extends JpaRepository<FormFDetailsModel,Integer> {
	@Query(value="select * from formf_details where ie_id=?1" , nativeQuery= true)
	public List<FormFDetailsModel> find(int ie_id);
	

}
