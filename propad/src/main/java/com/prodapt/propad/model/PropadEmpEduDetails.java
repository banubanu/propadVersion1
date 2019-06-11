package com.prodapt.propad.model;

	import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name = "propad_emp_edu_details")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public class PropadEmpEduDetails {
		
		@Id
		
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name = "ed_id")
		private int ed_id;
		private int ie_id;


		//		private int ed_emp_id;
		private byte[] ed_edu_sslc;
		private String ed_edu_sslc_text;;
		private byte[] ed_edu_hsc;
		private String ed_edu_hsc_text;
		private byte[] ed_edu_dip;
		private String ed_edu_dip_text;
		private byte[] ed_edu_ug;
		private String ed_edu_ug_text;
		private byte[] ed_edu_pg;
		private String ed_edu_pg_text;
		private byte[] ed_edu_others;
		private String ed_edu_others_text;
		private String ed_edu_comments;
//		private int mobile_no;
		private String sslc_status;
		private String hsc_status;
		private String dip_status;
		private String ug_status;
		private String pg_status;
		private String others_status;
		private String ed_emp_mail;
		
		public int getIe_id() {
			return ie_id;
		}

		public void setIe_id(int ie_id) {
			this.ie_id = ie_id;
		}
		
//		public int getMobile_no() {
//			return mobile_no;
//		}
//
//		public void setMobile_no(int mobile_no) {
//			this.mobile_no = mobile_no;
//		}

		
		public String getSslc_status() {
			return sslc_status;
		}

		public void setSslc_status(String sslc_status) {
			this.sslc_status = sslc_status;
		}

		public String getHsc_status() {
			return hsc_status;
		}

		public void setHsc_status(String hsc_status) {
			this.hsc_status = hsc_status;
		}

		public String getDip_status() {
			return dip_status;
		}

		public void setDip_status(String dip_status) {
			this.dip_status = dip_status;
		}

		public String getUg_status() {
			return ug_status;
		}

		public void setUg_status(String ug_status) {
			this.ug_status = ug_status;
		}

		public String getPg_status() {
			return pg_status;
		}

		public void setPg_status(String pg_status) {
			this.pg_status = pg_status;
		}

		public String getOthers_status() {
			return others_status;
		}

		public void setOthers_status(String others_status) {
			this.others_status = others_status;
		}

		public int getEd_id() {
			return ed_id;
		}

		public void setEd_id(int ed_id) {
			this.ed_id = ed_id;
		}

//		public int getEd_emp_id() {
//			return ed_emp_id;
//		}
//
//		public void setEd_emp_id(int ed_emp_id) {
//			this.ed_emp_id = ed_emp_id;
//		}

		public byte[] getEd_edu_sslc() {
			return ed_edu_sslc;
		}

		public void setEd_edu_sslc(byte[] bs) {
			this.ed_edu_sslc = bs;
		}

		public String getEd_edu_sslc_text() {
			return ed_edu_sslc_text;
		}

		public void setEd_edu_sslc_text(String ed_edu_sslc_text) {
			this.ed_edu_sslc_text = ed_edu_sslc_text;
		}

		public byte[] getEd_edu_hsc() {
			return ed_edu_hsc;
		}

		public void setEd_edu_hsc(byte[] bs) {
			this.ed_edu_hsc = bs;
		}

		public String getEd_edu_hsc_text() {
			return ed_edu_hsc_text;
		}

		public void setEd_edu_hsc_text(String ed_edu_hsc_text) {
			this.ed_edu_hsc_text = ed_edu_hsc_text;
		}

		public byte[] getEd_edu_dip() {
			return ed_edu_dip;
		}

		public void setEd_edu_dip(byte[] ed_edu_dip) {
			this.ed_edu_dip = ed_edu_dip;
		}

		public String getEd_edu_dip_text() {
			return ed_edu_dip_text;
		}

		public void setEd_edu_dip_text(String ed_edu_dip_text) {
			this.ed_edu_dip_text = ed_edu_dip_text;
		}

		public byte[] getEd_edu_ug() {
			return ed_edu_ug;
		}

		public void setEd_edu_ug(byte[] ed_edu_ug) {
			this.ed_edu_ug = ed_edu_ug;
		}

		public String getEd_edu_ug_text() {
			return ed_edu_ug_text;
		}

		public void setEd_edu_ug_text(String ed_edu_ug_text) {
			this.ed_edu_ug_text = ed_edu_ug_text;
		}

		public byte[] getEd_edu_pg() {
			return ed_edu_pg;
		}

		public void setEd_edu_pg(byte[] ed_edu_pg) {
			this.ed_edu_pg = ed_edu_pg;
		}

		public String getEd_edu_pg_text() {
			return ed_edu_pg_text;
		}

		public void setEd_edu_pg_text(String ed_edu_pg_text) {
			this.ed_edu_pg_text = ed_edu_pg_text;
		}

		public byte[] getEd_edu_others() {
			return ed_edu_others;
		}

		public void setEd_edu_others(byte[] ed_edu_others) {
			this.ed_edu_others = ed_edu_others;
		}

		public String getEd_edu_others_text() {
			return ed_edu_others_text;
		}

		public void setEd_edu_others_text(String ed_edu_others_text) {
			this.ed_edu_others_text = ed_edu_others_text;
		}

		public String getEd_edu_comments() {
			return ed_edu_comments;
		}

		public void setEd_edu_comments(String ed_edu_comments) {
			this.ed_edu_comments = ed_edu_comments;
		}

		

		public String getEd_emp_mail() {
			return ed_emp_mail;
		}

		public void setEd_emp_mail(String ed_emp_mail) {
			this.ed_emp_mail = ed_emp_mail;
		}

		@Override
		public String toString() {
			return "PropadEmpEduDetails [ed_id=" + ed_id + ", ed_edu_sslc="
					+ Arrays.toString(ed_edu_sslc) + ", ed_edu_sslc_text=" + ed_edu_sslc_text + ", ed_edu_hsc="
					+ Arrays.toString(ed_edu_hsc) + ", ed_edu_hsc_text=" + ed_edu_hsc_text + ", ed_edu_dip="
					+ Arrays.toString(ed_edu_dip) + ", ed_edu_dip_text=" + ed_edu_dip_text + ", ed_edu_ug="
					+ Arrays.toString(ed_edu_ug) + ", ed_edu_ug_text=" + ed_edu_ug_text + ", ed_edu_pg="
					+ Arrays.toString(ed_edu_pg) + ", ed_edu_pg_text=" + ed_edu_pg_text + ", ed_edu_others="
					+ Arrays.toString(ed_edu_others) + ", ed_edu_others_text=" + ed_edu_others_text
					+ ", ed_edu_comments=" + ed_edu_comments + ", sslc_status=" + sslc_status + ", hsc_status="
					+ hsc_status + ", dip_status=" + dip_status + ", ug_status=" + ug_status + ", pg_status="
					+ pg_status + ", others_status=" + others_status + ", ed_emp_mail=" + ed_emp_mail + "]";
		}

		
		
		
		


		
		}

		
		
	