package com.prodapt.propad.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MediclaimDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int mc_id;

	private int ie_id;
	private String mc_spouse_name;
	private Date mc_spouse_dob;
	private String mc_child1_name;
	private Date mc_child1_dob;
	private String mc_child1_sex;
	private String mc_child2_name;
	private Date mc_child2_dob;
	private String mc_child2_sex;
	private String mc_father_name;
	private Date mc_father_dob;
	private String mc_mother_name;
	private Date mc_mother_dob;
	public int getMc_id() {
		return mc_id;
	}
	public void setMc_id(int mc_id) {
		this.mc_id = mc_id;
	}
	public int getIe_id() {
		return ie_id;
	}
	public void setIe_id(int ie_id) {
		this.ie_id = ie_id;
	}
	public String getMc_spouse_name() {
		return mc_spouse_name;
	}
	public void setMc_spouse_name(String mc_spouse_name) {
		this.mc_spouse_name = mc_spouse_name;
	}
	public Date getMc_spouse_dob() {
		return mc_spouse_dob;
	}
	public void setMc_spouse_dob(Date mc_spouse_dob) {
		this.mc_spouse_dob = mc_spouse_dob;
	}
	public String getMc_child1_name() {
		return mc_child1_name;
	}
	public void setMc_child1_name(String mc_child1_name) {
		this.mc_child1_name = mc_child1_name;
	}
	public Date getMc_child1_dob() {
		return mc_child1_dob;
	}
	public void setMc_child1_dob(Date mc_child1_dob) {
		this.mc_child1_dob = mc_child1_dob;
	}
	public String getMc_child1_sex() {
		return mc_child1_sex;
	}
	public void setMc_child1_sex(String mc_child1_sex) {
		this.mc_child1_sex = mc_child1_sex;
	}
	public String getMc_child2_name() {
		return mc_child2_name;
	}
	public void setMc_child2_name(String mc_child2_name) {
		this.mc_child2_name = mc_child2_name;
	}
	public Date getMc_child2_dob() {
		return mc_child2_dob;
	}
	public void setMc_child2_dob(Date mc_child2_dob) {
		this.mc_child2_dob = mc_child2_dob;
	}
	public String getMc_child2_sex() {
		return mc_child2_sex;
	}
	public void setMc_child2_sex(String mc_child2_sex) {
		this.mc_child2_sex = mc_child2_sex;
	}
	public String getMc_father_name() {
		return mc_father_name;
	}
	public void setMc_father_name(String mc_father_name) {
		this.mc_father_name = mc_father_name;
	}
	public Date getMc_father_dob() {
		return mc_father_dob;
	}
	public void setMc_father_dob(Date mc_father_dob) {
		this.mc_father_dob = mc_father_dob;
	}
	public String getMc_mother_name() {
		return mc_mother_name;
	}
	public void setMc_mother_name(String mc_mother_name) {
		this.mc_mother_name = mc_mother_name;
	}
	public Date getMc_mother_dob() {
		return mc_mother_dob;
	}
	public void setMc_mother_dob(Date mc_mother_dob) {
		this.mc_mother_dob = mc_mother_dob;
	}
	
}
