package com.prodapt.propad.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "formf_nominee")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class FormFNomineeModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ff_nomi_id;
	private String ff_nomi_name;
	private String ff_nomi_relationship;
	private float ff_proportion;
	private int ff_nomi_age;
	private int ie_id;
	
	
	
	private String ff_nominee_address;
	
	public String getFf_nominee_address() {
		return ff_nominee_address;
	}
	public void setFf_nominee_address(String ff_nominee_address) {
		this.ff_nominee_address = ff_nominee_address;
	}
	
	public int getFf_nomi_id() {
		return ff_nomi_id;
	}
	public void setFf_nomi_id(int ff_nomi_id) {
		this.ff_nomi_id = ff_nomi_id;
	}
	public String getFf_nomi_name() {
		return ff_nomi_name;
	}
	public void setFf_nomi_name(String ff_nomi_name) {
		this.ff_nomi_name = ff_nomi_name;
	}
	public String getFf_nomi_relationship() {
		return ff_nomi_relationship;
	}
	public void setFf_nomi_relationship(String ff_nomi_relationship) {
		this.ff_nomi_relationship = ff_nomi_relationship;
	}
	public float getFf_proportion() {
		return ff_proportion;
	}
	public void setFf_proportion(float ff_proportion) {
		this.ff_proportion = ff_proportion;
	}
	public int getFf_nomi_age() {
		return ff_nomi_age;
	}
	public void setFf_nomi_age(int ff_nomi_age) {
		this.ff_nomi_age = ff_nomi_age;
	}
	public int getIe_id() {
		return ie_id;
	}
	public void setIe_id(int ie_id) {
		this.ie_id = ie_id;
	}
	

}
