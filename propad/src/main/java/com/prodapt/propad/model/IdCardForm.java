package com.prodapt.propad.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "idcard_form")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class IdCardForm {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "idcard_id")
	private int idcard_id;
	private int ie_id;
	private String ic_emp_name;
	private int ic_empcode;
	private String ic_address;
	private String ic_bloodgroup;
	private String ic_mobile;
	private String ic_vehicle1_name;
	private String ic_vehicle1_make;
	private String ic_vehicle1_model;
	private String ic_vehicle1_regn;
	private String ic_vehicle2_name;
	private String ic_vehicle2_make;
	private String ic_vehicle2_model;
	private String ic_vehicle2_regn;
	private byte[] ic_photo;
	private byte[] ic_sign;
	public int getIdcard_id() {
		return idcard_id;
	}
	public void setIdcard_id(int idcard_id) {
		this.idcard_id = idcard_id;
	}
	public int getIe_id() {
		return ie_id;
	}
	public void setIe_id(int ie_id) {
		this.ie_id = ie_id;
	}
	public String getIc_emp_name() {
		return ic_emp_name;
	}
	public void setIc_emp_name(String ic_emp_name) {
		this.ic_emp_name = ic_emp_name;
	}
	public int getIc_empcode() {
		return ic_empcode;
	}
	public void setIc_empcode(int ic_empcode) {
		this.ic_empcode = ic_empcode;
	}
	public String getIc_address() {
		return ic_address;
	}
	public void setIc_address(String ic_address) {
		this.ic_address = ic_address;
	}
	public String getIc_bloodgroup() {
		return ic_bloodgroup;
	}
	public void setIc_bloodgroup(String ic_bloodgroup) {
		this.ic_bloodgroup = ic_bloodgroup;
	}
	public String getIc_mobile() {
		return ic_mobile;
	}
	public void setIc_mobile(String ic_mobile) {
		this.ic_mobile = ic_mobile;
	}
	public String getIc_vehicle1_name() {
		return ic_vehicle1_name;
	}
	public void setIc_vehicle1_name(String ic_vehicle1_name) {
		this.ic_vehicle1_name = ic_vehicle1_name;
	}
	public String getIc_vehicle1_make() {
		return ic_vehicle1_make;
	}
	public void setIc_vehicle1_make(String ic_vehicle1_make) {
		this.ic_vehicle1_make = ic_vehicle1_make;
	}
	public String getIc_vehicle1_model() {
		return ic_vehicle1_model;
	}
	public void setIc_vehicle1_model(String ic_vehicle1_model) {
		this.ic_vehicle1_model = ic_vehicle1_model;
	}
	public String getIc_vehicle1_regn() {
		return ic_vehicle1_regn;
	}
	public void setIc_vehicle1_regn(String ic_vehicle1_regn) {
		this.ic_vehicle1_regn = ic_vehicle1_regn;
	}
	public String getIc_vehicle2_name() {
		return ic_vehicle2_name;
	}
	public void setIc_vehicle2_name(String ic_vehicle2_name) {
		this.ic_vehicle2_name = ic_vehicle2_name;
	}
	public String getIc_vehicle2_make() {
		return ic_vehicle2_make;
	}
	public void setIc_vehicle2_make(String ic_vehicle2_make) {
		this.ic_vehicle2_make = ic_vehicle2_make;
	}
	public String getIc_vehicle2_model() {
		return ic_vehicle2_model;
	}
	public void setIc_vehicle2_model(String ic_vehicle2_model) {
		this.ic_vehicle2_model = ic_vehicle2_model;
	}
	public String getIc_vehicle2_regn() {
		return ic_vehicle2_regn;
	}
	public void setIc_vehicle2_regn(String ic_vehicle2_regn) {
		this.ic_vehicle2_regn = ic_vehicle2_regn;
	}
	public byte[] getIc_photo() {
		return ic_photo;
	}
	public void setIc_photo(byte[] ic_photo) {
		this.ic_photo = ic_photo;
	}
	public byte[] getIc_sign() {
		return ic_sign;
	}
	public void setIc_sign(byte[] ic_sign) {
		this.ic_sign = ic_sign;
	}
	@Override
	public String toString() {
		return "IdCardForm [idcard_id=" + idcard_id + ", ie_id=" + ie_id + ", ic_emp_name=" + ic_emp_name
				+ ", ic_empcode=" + ic_empcode + ", ic_address=" + ic_address + ", ic_bloodgroup=" + ic_bloodgroup
				+ ", ic_mobile=" + ic_mobile + ", ic_vehicle1_name=" + ic_vehicle1_name + ", ic_vehicle1_make="
				+ ic_vehicle1_make + ", ic_vehicle1_model=" + ic_vehicle1_model + ", ic_vehicle1_regn="
				+ ic_vehicle1_regn + ", ic_vehicle2_name=" + ic_vehicle2_name + ", ic_vehicle2_make=" + ic_vehicle2_make
				+ ", ic_vehicle2_model=" + ic_vehicle2_model + ", ic_vehicle2_regn=" + ic_vehicle2_regn + ", ic_photo="
				+ Arrays.toString(ic_photo) + ", ic_sign=" + Arrays.toString(ic_sign) + "]";
	}

}
