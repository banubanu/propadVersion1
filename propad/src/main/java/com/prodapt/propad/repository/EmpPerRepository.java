package com.prodapt.propad.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.PropadEmpEduDetails;
import com.prodapt.propad.model.PropadEmpPerDetails;

@Repository
public interface EmpPerRepository extends JpaRepository<PropadEmpPerDetails, Integer> {

	
	@Query(value="select * from propad_emp_per_details where ep_per_mail=?1", nativeQuery = true)
	PropadEmpPerDetails getOneRow(String ep_per_mail);
	

	@Query(value = "SELECT ((CASE WHEN ep_per_addressproof IS NULL THEN 1 ELSE 0 END)+ (CASE WHEN ep_per_pp IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_per_pan IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_per_aadhar IS NULL THEN 1 ELSE 0 END)) AS sum_of_nulls FROM propad_emp_per_details where ie_id=?1", nativeQuery = true)
	Integer countnull(int ie_id);

	
	@Query(value="select * from propad_emp_per_details where ep_per_mail=?1", nativeQuery = true)
	List<PropadEmpPerDetails> findByEp_per_mail(String ep_per_mail);

	@Query(value="select * from propad_emp_per_details where ie_id=?1", nativeQuery = true)
	List<PropadEmpPerDetails> findByIe_id(int ie_id);

	

}

