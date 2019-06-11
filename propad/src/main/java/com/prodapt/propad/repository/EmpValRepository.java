package com.prodapt.propad.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.propad.model.PropadEmpValidation;

@Repository
public interface EmpValRepository extends JpaRepository<PropadEmpValidation, Integer> {

}
