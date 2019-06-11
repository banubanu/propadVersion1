package com.prodapt.propad.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PropadEmpValidation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ev_id;
	private int ev_emp_id;
	private Date ev_review_dt;
	private String ev_review_comments;
	private int uploadedPercentage;
	
	public int getEv_id() {
		return ev_id;
	}
	public void setEv_id(int ev_id) {
		this.ev_id = ev_id;
	}
	public int getEv_emp_id() {
		return ev_emp_id;
	}
	public void setEv_emp_id(int ev_emp_id) {
		this.ev_emp_id = ev_emp_id;
	}
	public int getUploadedPercentage() {
		return uploadedPercentage;
	}
	public void setUploadedPercentage(int uploadedPercentage) {
		this.uploadedPercentage = uploadedPercentage;
	}
	public Date getEv_review_dt() {
		return ev_review_dt;
	}
	public void setEv_review_dt(Date ev_review_dt) {
		this.ev_review_dt = ev_review_dt;
	}
	public String getEv_review_comments() {
		return ev_review_comments;
	}
	public void setEv_review_comments(String ev_review_comments) {
		this.ev_review_comments = ev_review_comments;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ev_emp_id;
		result = prime * result + ev_id;
		result = prime * result + ((ev_review_comments == null) ? 0 : ev_review_comments.hashCode());
		result = prime * result + ((ev_review_dt == null) ? 0 : ev_review_dt.hashCode());
		result = prime * result + uploadedPercentage;
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
		PropadEmpValidation other = (PropadEmpValidation) obj;
		if (ev_emp_id != other.ev_emp_id)
			return false;
		if (ev_id != other.ev_id)
			return false;
		if (ev_review_comments == null) {
			if (other.ev_review_comments != null)
				return false;
		} else if (!ev_review_comments.equals(other.ev_review_comments))
			return false;
		if (ev_review_dt == null) {
			if (other.ev_review_dt != null)
				return false;
		} else if (!ev_review_dt.equals(other.ev_review_dt))
			return false;
		if (uploadedPercentage != other.uploadedPercentage)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PropadEmpValidation [ev_id=" + ev_id + ", ev_emp_id=" + ev_emp_id + ", ev_review_dt=" + ev_review_dt
				+ ", ev_review_comments=" + ev_review_comments + ", uploadedPercentage=" + uploadedPercentage + "]";
	}

	
	
	

}
