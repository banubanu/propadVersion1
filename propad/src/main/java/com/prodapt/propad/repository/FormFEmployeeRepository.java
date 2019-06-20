package com.prodapt.propad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.FormFEmployeeModel;
import com.prodapt.propad.model.FormFNomineeModel;


@Repository
public interface FormFEmployeeRepository extends JpaRepository<FormFEmployeeModel,Integer> {
	@Query(value="select * from formf_employee where ie_id=?1" , nativeQuery= true)
	public List<FormFEmployeeModel> find(int ie_id);
}
