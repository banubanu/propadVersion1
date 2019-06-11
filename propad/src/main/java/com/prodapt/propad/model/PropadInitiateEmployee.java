package com.prodapt.propad.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class PropadInitiateEmployee  {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ie_id;
	private int ie_emp_id;
	private String ie_emp_name;
	private String ie_emp_email;
	private Date ie_emp_doj;

	private String ie_status;
	private Date ie_emp_date;
//	private int ie_document_status;

//	public int getIe_document_status() {
//		return ie_document_status;
//	}
//	public void setIe_document_status(int ie_document_status) {
//		this.ie_document_status = ie_document_status;
//	}
	public Date getIe_emp_date() {
		return ie_emp_date;
	}
	public void setIe_emp_date(Date ie_emp_date) {
		this.ie_emp_date = ie_emp_date;
	}
	
	public int getIe_id() {
		return ie_id;
	}
	public void setIe_id(int ie_id) {
		this.ie_id = ie_id;
	}
	public int getIe_emp_id() {
		return ie_emp_id;
	}
	public void setIe_emp_id(int ie_emp_id) {
		this.ie_emp_id = ie_emp_id;
	}
	public String getIe_emp_name() {
		return ie_emp_name;
	}
	public void setIe_emp_name(String ie_emp_name) {
		this.ie_emp_name = ie_emp_name;
	}
	public String getIe_emp_email() {
		return ie_emp_email;
	}
	public void setIe_emp_email(String string) {
		this.ie_emp_email = string;
	}
	public Date getIe_emp_doj() {
		return ie_emp_doj;
	}
	public void setIe_emp_doj(Date ie_emp_doj) {
		this.ie_emp_doj = ie_emp_doj;
	}
//	public String getIe_int1() {
//		return ie_int1;
//	}
//	public void setIe_int1(String ie_int1) {
//		this.ie_int1 = ie_int1;
//	}
//	public String getIe_int2() {
//		return ie_int2;
//	}
//	public void setIe_int2(String ie_int2) {
//		this.ie_int2 = ie_int2;
//	}
	public String getIe_status() {
		return ie_status;
	}
	public void setIe_status(String ie_status) {
		this.ie_status = ie_status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((ie_emp_date == null) ? 0 : ie_emp_date.hashCode());
		result = prime * result + ((ie_emp_doj == null) ? 0 : ie_emp_doj.hashCode());
		result = prime * result + ((ie_emp_email == null) ? 0 : ie_emp_email.hashCode());
		result = prime * result + ie_emp_id;
		result = prime * result + ((ie_emp_name == null) ? 0 : ie_emp_name.hashCode());
		result = prime * result + ie_id;
		result = prime * result + ((ie_status == null) ? 0 : ie_status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PropadInitiateEmployee other = (PropadInitiateEmployee) obj;
		
		if (ie_emp_date == null) {
			if (other.ie_emp_date != null)
				return false;
		} else if (!ie_emp_date.equals(other.ie_emp_date))
			return false;
		if (ie_emp_doj == null) {
			if (other.ie_emp_doj != null)
				return false;
		} else if (!ie_emp_doj.equals(other.ie_emp_doj))
			return false;
		if (ie_emp_email == null) {
			if (other.ie_emp_email != null)
				return false;
		} else if (!ie_emp_email.equals(other.ie_emp_email))
			return false;
		if (ie_emp_id != other.ie_emp_id)
			return false;
		if (ie_emp_name == null) {
			if (other.ie_emp_name != null)
				return false;
		} else if (!ie_emp_name.equals(other.ie_emp_name))
			return false;
		if (ie_id != other.ie_id)
			return false;
		if (ie_status == null) {
			if (other.ie_status != null)
				return false;
		} else if (!ie_status.equals(other.ie_status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PropadInitiateEmployee [ie_id=" + ie_id + ", ie_emp_id=" + ie_emp_id + ", ie_emp_name=" + ie_emp_name
				+ ", ie_emp_email=" + ie_emp_email + ", ie_emp_doj=" + ie_emp_doj + ", ie_status=" + ie_status
				+ ", ie_emp_date=" + ie_emp_date + "]";
	}
	
	
	
	
}
