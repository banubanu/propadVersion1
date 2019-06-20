package com.prodapt.propad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.prodapt.propad.model.FormFEmployerModel;

@Repository
public interface FormFEmployerRepository extends JpaRepository <FormFEmployerModel,Integer> {
	@Query(value="select * from formf_employer where ie_id=?1" , nativeQuery= true)
	public List<FormFEmployerModel> find(int ie_id);
}
