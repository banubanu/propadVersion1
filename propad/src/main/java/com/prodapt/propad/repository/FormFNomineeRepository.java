package com.prodapt.propad.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.prodapt.propad.model.FormFNomineeModel;
import com.prodapt.propad.model.FormFWitnessModel;



@Repository
public interface FormFNomineeRepository extends JpaRepository<FormFNomineeModel,Integer> {

	

	@Query(value="select * from formf_nominee where ie_id=?1" , nativeQuery= true)
	public List<FormFNomineeModel> find(int ie_id);
}
