package com.prodapt.propad.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.PropadEmpEduDetails;

@Repository
public interface EmpEduRepository extends JpaRepository<PropadEmpEduDetails, Integer> {

	@Query(value = "SELECT ((CASE WHEN ed_edu_sslc IS NULL THEN 1 ELSE 0 END)+ (CASE WHEN ed_edu_hsc IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ed_edu_dip IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ed_edu_ug IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ed_edu_pg IS NULL THEN 1 ELSE 0 END)) AS sum_of_nulls FROM propad_emp_edu_details where ie_id=?1", nativeQuery = true)
	public Integer countnull(int ie_id);
	
	@Query(value="select * from propad_emp_edu_details where ed_emp_mail=?1", nativeQuery = true)
	public PropadEmpEduDetails getOneRow(String ed_emp_mail);
	
	@Query(value="select * from propad_emp_edu_details where ie_id=?1", nativeQuery = true)
	public List<PropadEmpEduDetails> findByIe_id(int ie_id);

	@Query(value="select sslc_status,hsc_status,dip_status,ug_status,pg_status from propad_emp_edu_details where ed_emp_mail=?1", nativeQuery = true)
	public List<PropadEmpEduDetails[]> findPendingDocument(String ed_emp_mail);
	
	@Query(value="select * from propad_emp_edu_details where ed_emp_mail=?1", nativeQuery = true)
	public List<PropadEmpEduDetails> findByEd_emp_mail(String ed_emp_mail);	

	

}
