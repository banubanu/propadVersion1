package com.prodapt.propad.dto;

import java.util.Date;

public class FormFEmployerDTO {
	
	private int ff_employer_id;
	private String ff_employer_sign;
	private String ff_employer_designation;
	private Date ff_date;
	private int ie_id;
	private int ff_emp_ref_num;
	
	
	public int getFf_emp_ref_num() {
		return ff_emp_ref_num;
	}
	public void setFf_emp_ref_num(int ff_emp_ref_num) {
		this.ff_emp_ref_num = ff_emp_ref_num;
	}
	
	public int getIe_id() {
		return ie_id;
	}
	public void setIe_id(int ie_id) {
		this.ie_id = ie_id;
	}
	
	public int getFf_employer_id() {
		return ff_employer_id;
	}
	public void setFf_employer_id(int ff_employer_id) {
		this.ff_employer_id = ff_employer_id;
	}
	public String getFf_employer_sign() {
		return ff_employer_sign;
	}
	public void setFf_employer_sign(String ff_employer_sign) {
		this.ff_employer_sign = ff_employer_sign;
	}
	public String getFf_employer_designation() {
		return ff_employer_designation;
	}
	public void setFf_employer_designation(String ff_employer_designation) {
		this.ff_employer_designation = ff_employer_designation;
	}
	public Date getFf_date() {
		return ff_date;
	}
	public void setFf_date(Date ff_date) {
		this.ff_date = ff_date;
	}
	public int getFf_emp_id() {
		return ff_emp_id;
	}
	public void setFf_emp_id(int ff_emp_id) {
		this.ff_emp_id = ff_emp_id;
	}
	private int ff_emp_id;


}
