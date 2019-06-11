package com.prodapt.propad.dto;



	import java.sql.Blob;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;

	
	public class EmployeePerDTO {
		
		
		private int eper_id;
		private int ie_id;
		public int getIe_id() {
			return ie_id;
		}
		public void setIe_id(int ie_id) {
			this.ie_id = ie_id;
		}
		private int ep_per_emp_id;
		private byte[] ep_per_addressproof;
		private String ep_per_addressproof_text;
		private byte[] ep_per_pp;
		private String ep_per_pp_text;
		private byte[] ep_per_pan;
		private String ep_per_pan_text;
		private byte[] ep_per_aadhar;
		private String ep_per_aadhar_text;
		private String ep_per_mail;
		private String addressproof_status;
		private String aadhar_status;
		private String pp_status;
		private String pan_status;
		
		
		
		public String getEp_per_mail() {
			return ep_per_mail;
		}
		public void setEp_per_mail(String ep_per_mail) {
			this.ep_per_mail = ep_per_mail;
		}
		public String getAddressproof_status() {
			return addressproof_status;
		}
		public void setAddressproof_status(String addressproof_status) {
			this.addressproof_status = addressproof_status;
		}
		public String getAadhar_status() {
			return aadhar_status;
		}
		public void setAadhar_status(String aadhar_status) {
			this.aadhar_status = aadhar_status;
		}
		public String getPp_status() {
			return pp_status;
		}
		public void setPp_status(String pp_status) {
			this.pp_status = pp_status;
		}
		public String getPan_status() {
			return pan_status;
		}
		public void setPan_status(String pan_status) {
			this.pan_status = pan_status;
		}
		public int getEper_id() {
			return eper_id;
		}
		public void setEper_id(int eper_id) {
			this.eper_id = eper_id;
		}
		public int getEp_per_emp_id() {
			return ep_per_emp_id;
		}
		public void setEp_per_emp_id(int ep_per_emp_id) {
			this.ep_per_emp_id = ep_per_emp_id;
		}
		public byte[] getEp_per_addressproof() {
			return ep_per_addressproof;
		}
		public void setEp_per_addressproof(byte[] ep_per_addressproof) {
			this.ep_per_addressproof = ep_per_addressproof;
		}
		public String getEp_per_addressproof_text() {
			return ep_per_addressproof_text;
		}
		public void setEp_per_addressproof_text(String ep_per_addressproof_text) {
			this.ep_per_addressproof_text = ep_per_addressproof_text;
		}
		public byte[] getEp_per_pp() {
			return ep_per_pp;
		}
		public void setEp_per_pp(byte[] ep_per_pp) {
			this.ep_per_pp = ep_per_pp;
		}
		public String getEp_per_pp_text() {
			return ep_per_pp_text;
		}
		public void setEp_per_pp_text(String ep_per_pp_text) {
			this.ep_per_pp_text = ep_per_pp_text;
		}
		public byte[] getEp_per_pan() {
			return ep_per_pan;
		}
		public void setEp_per_pan(byte[] ep_per_pan) {
			this.ep_per_pan = ep_per_pan;
		}
		public String getEp_per_pan_text() {
			return ep_per_pan_text;
		}
		public void setEp_per_pan_text(String ep_per_pan_text) {
			this.ep_per_pan_text = ep_per_pan_text;
		}
		public byte[] getEp_per_aadhar() {
			return ep_per_aadhar;
		}
		public void setEp_per_aadhar(byte[] ep_per_aadhar) {
			this.ep_per_aadhar = ep_per_aadhar;
		}
		public String getEp_per_aadhar_text() {
			return ep_per_aadhar_text;
		}
		public void setEp_per_aadhar_text(String ep_per_aadhar_text) {
			this.ep_per_aadhar_text = ep_per_aadhar_text;
		}
		
		
}
