package com.prodapt.propad.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.PropadEmpPerDetails;
import com.prodapt.propad.model.PropadEmpProfDetails;

@Repository
public interface EmpProfRepository extends JpaRepository<PropadEmpProfDetails, Integer> {
	@Query(value = "SELECT ((CASE WHEN ep_service_cert1 IS NULL THEN 1 ELSE 0 END)+ (CASE WHEN ep_service_cert2 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_service_cert3 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_payslip1 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_payslip2 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN ep_payslip3 IS NULL THEN 1 ELSE 0 END)) AS sum_of_nulls FROM propad_emp_prof_details where ie_id=?1", nativeQuery = true)
	public Integer countnull(int ie_id);
	
	@Query(value="select * from propad_emp_prof_details where ep_prof_mail=?1", nativeQuery = true)
	public PropadEmpProfDetails getOneRow(String ep_prof_mail);
	
	@Query(value="select * from propad_emp_prof_details where ep_prof_mail=?1", nativeQuery = true)
	 List<PropadEmpProfDetails> findByEp_prof_mail(String ep_prof_mail);
	
	@Query(value="select * from propad_emp_prof_details where ie_id=?1", nativeQuery = true)
	public List<PropadEmpProfDetails> findByIe_id(int ie_id);
	
	



}

