package com.prodapt.propad.dto;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class EmployeeDTO {
	
	private int ie_id;
	private int ie_emp_id;
	private String ie_emp_name;
	private String ie_emp_email;
	private Date ie_emp_doj;
	private String ie_status;
	private Date ie_emp_date;
//private int ie_document_status;

	public Date getIe_emp_date() {
		return ie_emp_date;
	}
//	public int getIe_document_status() {
//		return ie_document_status;
//	}
//	public void setIe_document_status(int ie_document_status) {
//		this.ie_document_status = ie_document_status;
//	}
	public void setIe_emp_date(Date ie_emp_date) {
		this.ie_emp_date = ie_emp_date;
	}

	public void setIe_emp_doj(Date ie_emp_doj) {
		this.ie_emp_doj = ie_emp_doj;
	}
	public Date getIe_date() {
		return ie_emp_date;
	}
	public Date setIe_date() {
		return this.ie_emp_date = new Date();
	}
	
	public int getIe_id() {
		return ie_id;
	}
	public int setIe_id(int ie_id) {
		return this.ie_id = ie_id;
	}
	public int getIe_emp_id() {
		return ie_emp_id;
	}
	public int setIe_emp_id(int ie_emp_id) {
		return this.ie_emp_id = ie_emp_id;
	}
	public String getIe_emp_name() {
		return ie_emp_name;
	}
	public String setIe_emp_name(String ie_emp_name) {
		return this.ie_emp_name = ie_emp_name;
		
	}
	public String getIe_emp_email() {
		return ie_emp_email;
	}
	public String setIe_emp_email(String ie_emp_email) {
		return this.ie_emp_email = ie_emp_email;
	}
	public Date getIe_emp_doj() {
		return ie_emp_doj;
	}
	public Date  setIe_emp_doj() {
		return this.ie_emp_doj = new Date() ;
	}

	public String getIe_status() {
		return ie_status;
	}
	public String  setIe_status(String ie_status) {
		return this.ie_status = ie_status;
	}

}
