package com.prodapt.propad.dto;

import java.sql.Blob;
import org.springframework.web.multipart.MultipartFile;

public class EmpTechDTO {

	private int et_id;
	private int ie_id;
	public int getIe_id() {
		return ie_id;
	}
	public void setIe_id(int ie_id) {
		this.ie_id = ie_id;
	}
	private int et_emp_id;
	private byte[] et_tech_cert1;
	private String et_tech_cert1_text;
	private byte[] et_tech_cert2;
	private String et_tech_cert2_text;
	private byte[] et_tech_cert3;
	private String et_tech_cert3_text;
	private byte[] et_tech_cert4;
	private String et_tech_cert4_text;
	private byte[] et_tech_cert5;
	private String et_tech_cert5_text;
	private String et_tech_comments;
	private String et_emp_mail;
	
	private String tech1_status;
	private String tech2_status;
	private String tech3_status;
	private String tech4_status;
	private String tech5_status;
	
	
	
	public String getEt_emp_mail() {
		return et_emp_mail;
	}
	public void setEt_emp_mail(String et_emp_mail) {
		this.et_emp_mail = et_emp_mail;
	}
	public String getTech1_status() {
		return tech1_status;
	}
	public void setTech1_status(String tech1_status) {
		this.tech1_status = tech1_status;
	}
	public String getTech2_status() {
		return tech2_status;
	}
	public void setTech2_status(String tech2_status) {
		this.tech2_status = tech2_status;
	}
	public String getTech3_status() {
		return tech3_status;
	}
	public void setTech3_status(String tech3_status) {
		this.tech3_status = tech3_status;
	}
	public String getTech4_status() {
		return tech4_status;
	}
	public void setTech4_status(String tech4_status) {
		this.tech4_status = tech4_status;
	}
	public String getTech5_status() {
		return tech5_status;
	}
	public void setTech5_status(String tech5_status) {
		this.tech5_status = tech5_status;
	}
	public String getEt_tech_comments() {
		return et_tech_comments;
	}
	public void setEt_tech_comments(String et_tech_comments) {
		this.et_tech_comments = et_tech_comments;
	}
	public int getEt_id() {
		return et_id;
	}
	public int setEt_id(int et_id) {
		return this.et_id = et_id;
	}
	public int getEt_emp_id() {
		return et_emp_id;
	}
	public int setEt_emp_id(int et_emp_id) {
		return this.et_emp_id = et_emp_id;
	}
	public byte[] getEt_tech_cert1() {
		return et_tech_cert1;
	}
	public byte[] setEt_tech_cert1(byte[] et_tech_cert1) {
		return this.et_tech_cert1 = et_tech_cert1;
	}
	public String getEt_tech_cert1_text() {
		return et_tech_cert1_text;
	}
	public String setEt_tech_cert1_text(String et_tech_cert1_text) {
		return this.et_tech_cert1_text = et_tech_cert1_text;
	}
	public byte[] getEt_tech_cert2() {
		return et_tech_cert2;
	}
	public byte[] setEt_tech_cert2(byte[] et_tech_cert2) {
		return this.et_tech_cert2 = et_tech_cert2;
	}
	public String getEt_tech_cert2_text() {
		return et_tech_cert2_text;
	}
	public String setEt_tech_cert2_text(String et_tech_cert2_text) {
		return this.et_tech_cert2_text = et_tech_cert2_text;
	}
	public byte[] getEt_tech_cert3() {
		return et_tech_cert3;
	}
	public byte[] setEt_tech_cert3(byte[] et_tech_cert3) {
		return this.et_tech_cert3 = et_tech_cert3;
	}
	public String getEt_tech_cert3_text() {
		return et_tech_cert3_text;
	}
	public String setEt_tech_cert3_text(String et_tech_cert3_text) {
		return this.et_tech_cert3_text = et_tech_cert3_text;
	}
	public byte[] getEt_tech_cert4() {
		return et_tech_cert4;
	}
	public byte[] setEt_tech_cert4(byte[] et_tech_cert4) {
		return this.et_tech_cert4 = et_tech_cert4;
	}
	
	public String getEt_tech_cert4_text() {
		return et_tech_cert4_text;
	}
	public String setEt_tech_cert4_text(String et_tech_cert4_text) {
		return this.et_tech_cert4_text = et_tech_cert4_text;
	}
	public byte[] getEt_tech_cert5() {
		return et_tech_cert5;
	}
	public byte[] setEt_tech_cert5(byte[] et_tech_cert5) {
		return this.et_tech_cert5 = et_tech_cert5;
	}
	public String getEt_tech_cert5_text() {
		return et_tech_cert5_text;
	}
	public String setEt_tech_cert5_text(String et_tech_cert5_text) {
		return this.et_tech_cert5_text = et_tech_cert5_text;
	}
	
	
}
