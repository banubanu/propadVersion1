package com.prodapt.propad.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.FormFWitnessModel;


@Repository
public interface FormFWitnessRepository extends JpaRepository<FormFWitnessModel,Integer>{

	@Query(value="select * from formf_witness where ie_id=?1" , nativeQuery= true)
	public List<FormFWitnessModel> find(int ie_id);

		//ElComment findByElCommentCourseId(int c);
	
//public List<FormFWitnessModel> findByFfWitnessId(int id);
		
	
}
