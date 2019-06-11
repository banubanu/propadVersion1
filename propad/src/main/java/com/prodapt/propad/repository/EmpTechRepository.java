package com.prodapt.propad.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.PropadEmpTechDetails;

@Repository
public interface EmpTechRepository extends JpaRepository<PropadEmpTechDetails, Integer> {
//	public static final String FIND_DOCUMENT = "select p.et_id,p.et_emp_id from propad_emp_tech_details p";
	
	@Query(value = "SELECT ((CASE WHEN et_tech_cert1 IS NULL THEN 1 ELSE 0 END)+ (CASE WHEN et_tech_cert2 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN et_tech_cert3 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN et_tech_cert4 IS NULL THEN 1 ELSE 0 END)+(CASE WHEN et_tech_cert5 IS NULL THEN 1 ELSE 0 END)) AS sum_of_nulls FROM propad_emp_tech_details where ie_id=?1", nativeQuery = true)
	public Integer countnull(int ie_id);

	@Query(value="select * from propad_emp_tech_details where et_emp_mail=?1", nativeQuery = true)
	public PropadEmpTechDetails getOneRow(String et_emp_mail);
	
//	
	
	@Query(value="select * from propad_emp_tech_details where et_emp_mail=?1", nativeQuery = true)
	public List<PropadEmpTechDetails> findByEt_emp_mail(String et_emp_mail);
	
	@Query(value="select * from propad_emp_tech_details where ie_id=?1", nativeQuery = true)
	public List<PropadEmpTechDetails> findByIe_id(int  ie_id);
	
@Query(value="select tech1_status,tech2_status,tech3_status,tech4_status,tech5_status from propad_emp_tech_details where et_emp_mail=?1",nativeQuery= true)
public  List<PropadEmpTechDetails> findPendingDocuments(String et_emp_mail);

}



