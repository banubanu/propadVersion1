package com.prodapt.propad.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "formf_witness")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class FormFWitnessModel {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int ff_witness_id;
	private String ff_witness_name;

	private String ff_witness_place;
	private String ff_witness_address;
	private Date ff_witness_date;
	
	
	private int ie_id;
	
	
	public int getFf_witness_id() {
		return ff_witness_id;
	}

	public void setFf_witness_id(int ff_witness_id) {
		this.ff_witness_id = ff_witness_id;
	}

	public String getFf_witness_name() {
		return ff_witness_name;
	}

	public void setFf_witness_name(String ff_witness_name) {
		this.ff_witness_name = ff_witness_name;
	}

	

	public String getFf_witness_address() {
		return ff_witness_address;
	}

	public void setFf_witness_address(String ff_witness_address) {
		this.ff_witness_address = ff_witness_address;
	}

	public String getFf_witness_place() {
		return ff_witness_place;
	}

	public void setFf_witness_place(String ff_witness_place) {
		this.ff_witness_place = ff_witness_place;
	}

	public Date getFf_witness_date() {
		return ff_witness_date;
	}

	public void setFf_witness_date(Date ff_witness_date) {
		this.ff_witness_date = ff_witness_date;
	}

	public int getIe_id() {
		return ie_id;
	}

	public void setIe_id(int ie_id) {
		this.ie_id = ie_id;
	}

	
	@Override
	public String toString() {
		return "FormFWitnessDetailsDTO [ff_witness_name=" + ff_witness_name + ", ff_witness_id=" + ff_witness_id
				+ ", ff_witness_address=" + ff_witness_address + ", ff_witness_place=" + ff_witness_place + ",ff_witness_date="
				+ ff_witness_date + ", ie_id=" + ie_id + "]";
	}
	

}
