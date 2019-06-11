package com.prodapt.propad.model;

import java.sql.Blob;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PropadEmpProfDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int ep_id;
	private String camera_file;
public String getCamera_file() {
		return camera_file;
	}
	public void setCamera_file(String camera_file) {
		this.camera_file = camera_file;
	}
	//	private int ep_emp_id;
	private int ie_id;
	private byte[] ep_service_cert1;
	private String ep_service_cert1_text;
	private byte[] ep_service_cert2;
	public int getIe_id() {
		return ie_id;
	}
	public void setIe_id(int ie_id) {
		this.ie_id = ie_id;
	}
	private String ep_service_cert2_text;
	private byte[] ep_service_cert3;
	private String ep_service_cert3_text;
	private byte[] ep_payslip1;
	private String ep_payslip1_text;
	private byte[] ep_payslip2;
	private String ep_payslip2_text;
	private byte[] ep_payslip3;
	private String ep_payslip3_text;
	private String ep_prof_mail;
	
	
	private String service1_status;
	private String service2_status;
	private String service3_status;
	private String payslip1_status;
	private String payslip2_status;
	private String payslip3_status;
	
	
	
	
	public String getEp_prof_mail() {
		return ep_prof_mail;
	}
	public void setEp_prof_mail(String ep_prof_mail) {
		this.ep_prof_mail = ep_prof_mail;
	}
	
	
	
	
	public String getService1_status() {
		return service1_status;
	}
	public void setService1_status(String service1_status) {
		this.service1_status = service1_status;
	}
	public String getService2_status() {
		return service2_status;
	}
	public void setService2_status(String service2_status) {
		this.service2_status = service2_status;
	}
	public String getService3_status() {
		return service3_status;
	}
	public void setService3_status(String service3_status) {
		this.service3_status = service3_status;
	}
	public String getPayslip1_status() {
		return payslip1_status;
	}
	public void setPayslip1_status(String payslip1_status) {
		this.payslip1_status = payslip1_status;
	}
	public String getPayslip2_status() {
		return payslip2_status;
	}
	public void setPayslip2_status(String payslip2_status) {
		this.payslip2_status = payslip2_status;
	}
	public String getPayslip3_status() {
		return payslip3_status;
	}
	public void setPayslip3_status(String payslip3_status) {
		this.payslip3_status = payslip3_status;
	}
	public int getEp_id() {
		return ep_id;
	}
	public void setEp_id(int ep_id) {
		this.ep_id = ep_id;
	}
	
	public byte[] getEp_service_cert1() {
		return ep_service_cert1;
	}
	public void setEp_service_cert1(byte[] bs) {
		this.ep_service_cert1 = bs;
	}
	public String getEp_service_cert1_text() {
		return ep_service_cert1_text;
	}
	public void setEp_service_cert1_text(String ep_service_cert1_text) {
		this.ep_service_cert1_text = ep_service_cert1_text;
	}
	public byte[] getEp_service_cert2() {
		return ep_service_cert2;
	}
	public void setEp_service_cert2(byte[] bs) {
		this.ep_service_cert2 = bs;
	}
	public String getEp_service_cert2_text() {
		return ep_service_cert2_text;
	}
	public void setEp_service_cert2_text(String ep_service_cert2_text) {
		this.ep_service_cert2_text = ep_service_cert2_text;
	}
	public byte[] getEp_service_cert3() {
		return ep_service_cert3;
	}
	public void setEp_service_cert3(byte[] ep_service_cert3) {
		this.ep_service_cert3 = ep_service_cert3;
	}
	public String getEp_service_cert3_text() {
		return ep_service_cert3_text;
	}
	public void setEp_service_cert3_text(String ep_service_cert3_text) {
		this.ep_service_cert3_text = ep_service_cert3_text;
	}
	public byte[] getEp_payslip1() {
		return ep_payslip1;
	}
	public void setEp_payslip1(byte[] ep_payslip1) {
		this.ep_payslip1 = ep_payslip1;
	}
	public String getEp_payslip1_text() {
		return ep_payslip1_text;
	}
	public void setEp_payslip1_text(String ep_payslip1_text) {
		this.ep_payslip1_text = ep_payslip1_text;
	}
	public byte[] getEp_payslip2() {
		return ep_payslip2;
	}
	public void setEp_payslip2(byte[] ep_payslip2) {
		this.ep_payslip2 = ep_payslip2;
	}
	public String getEp_payslip2_text() {
		return ep_payslip2_text;
	}
	public void setEp_payslip2_text(String ep_payslip2_text) {
		this.ep_payslip2_text = ep_payslip2_text;
	}
	public byte[] getEp_payslip3() {
		return ep_payslip3;
	}
	public void setEp_payslip3(byte[] ep_payslip3) {
		this.ep_payslip3 = ep_payslip3;
	}
	public String getEp_payslip3_text() {
		return ep_payslip3_text;
	}
	public void setEp_payslip3_text(String ep_payslip3_text) {
		this.ep_payslip3_text = ep_payslip3_text;
	}
	@Override
	public String toString() {
		return "PropadEmpProfDetails [ep_id=" + ep_id + ", camera_file=" + camera_file + ", ie_id=" + ie_id
				+ ", ep_service_cert1=" + Arrays.toString(ep_service_cert1) + ", ep_service_cert1_text="
				+ ep_service_cert1_text + ", ep_service_cert2=" + Arrays.toString(ep_service_cert2)
				+ ", ep_service_cert2_text=" + ep_service_cert2_text + ", ep_service_cert3="
				+ Arrays.toString(ep_service_cert3) + ", ep_service_cert3_text=" + ep_service_cert3_text
				+ ", ep_payslip1=" + Arrays.toString(ep_payslip1) + ", ep_payslip1_text=" + ep_payslip1_text
				+ ", ep_payslip2=" + Arrays.toString(ep_payslip2) + ", ep_payslip2_text=" + ep_payslip2_text
				+ ", ep_payslip3=" + Arrays.toString(ep_payslip3) + ", ep_payslip3_text=" + ep_payslip3_text
				+ ", ep_prof_mail=" + ep_prof_mail + ", service1_status=" + service1_status + ", service2_status="
				+ service2_status + ", service3_status=" + service3_status + ", payslip1_status=" + payslip1_status
				+ ", payslip2_status=" + payslip2_status + ", payslip3_status=" + payslip3_status + "]";
	}
	
	
	
	
}

