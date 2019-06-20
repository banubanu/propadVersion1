package com.prodapt.propad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.CompanyApplicationForm;
import com.prodapt.propad.model.IdCardForm;


@Repository

public interface CompanyApplicationRepository extends JpaRepository<CompanyApplicationForm, Integer>{

@Query(value="select * from company_application_form where ie_id=?1", nativeQuery = true)
public  List<CompanyApplicationForm> findByIe_id(int  ie_id);



}

