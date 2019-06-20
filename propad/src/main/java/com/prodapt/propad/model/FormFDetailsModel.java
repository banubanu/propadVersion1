package com.prodapt.propad.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "formf_details")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class FormFDetailsModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int ff_emp_id;
	private String ff_empto;
	private String ff_emp_name;
	private int ie_id;
	
	
	public int getFf_emp_id() {
		return ff_emp_id;
	}
	public void setFf_emp_id(int ff_emp_id) {
		this.ff_emp_id = ff_emp_id;
	}
	public String getFf_empto() {
		return ff_empto;
	}
	public void setFf_empTo(String ff_empto) {
		this.ff_empto = ff_empto;
	}
	public String getFf_emp_name() {
		return ff_emp_name;
	}
	public void setFf_emp_name(String ff_emp_name) {
		this.ff_emp_name = ff_emp_name;
	}
	public int getIe_id() {
		return ie_id;
	}
	public void setIe_id(int ie_id) {
		this.ie_id = ie_id;
	}
	
	@Override
	public String toString() {
		return "FormFWitnessDetailsDTO [ff_emp_id=" + ff_emp_id+ ", ff_empto=" + ff_empto + ",ff_emp_name="
				+ ff_emp_name + ", ie_id=" + ie_id + "]";
	}
	
}
