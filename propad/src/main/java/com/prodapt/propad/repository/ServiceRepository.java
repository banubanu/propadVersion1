package com.prodapt.propad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.PropadInitiateEmployee;

@Repository
public interface ServiceRepository extends JpaRepository<PropadInitiateEmployee, Integer> {

	@Query(value="select * from propad_initiate_employee where ie_emp_email=?1", nativeQuery = true)
	List<PropadInitiateEmployee> getOneRow(String ie_emp_mail);

	@Query(value="select ie_emp_id from propad_initiate_employee where ie_emp_id=?1", nativeQuery = true)
	List<PropadInitiateEmployee> getByEmpid(int ie_emp_id);

}
