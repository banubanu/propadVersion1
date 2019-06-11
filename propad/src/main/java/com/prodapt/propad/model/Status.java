package com.prodapt.propad.model;


public class Status {

       
       private Integer statusCode=400;
       private String message;
       private PropadEmpPerDetails propadEmpPerDetails;
       private PropadEmpTechDetails propadEmpTechDetails;
       private PropadEmpProfDetails propadEmpProfDetails;
       private PropadUsers propadUser;
       
       public PropadUsers getPropadUser() {
		return propadUser;
	}
	public void setPropadUser(PropadUsers propadUser) {
		this.propadUser = propadUser;
	}
	public PropadEmpProfDetails getPropadEmpProfDetails() {
		return propadEmpProfDetails;
	}
	public void setPropadEmpProfDetails(PropadEmpProfDetails propadEmpProfDetails) {
		this.propadEmpProfDetails = propadEmpProfDetails;
	}
	public PropadEmpEduDetails getPropadEmpEduDetails() {
		return propadEmpEduDetails;
	}
	public void setPropadEmpEduDetails(PropadEmpEduDetails propadEmpEduDetails) {
		this.propadEmpEduDetails = propadEmpEduDetails;
	}
	private PropadEmpEduDetails propadEmpEduDetails;
       
	public PropadEmpTechDetails getPropadEmpTechDetails() {
		return propadEmpTechDetails;
	}
	public void setPropadEmpTechDetails(PropadEmpTechDetails propadEmpTechDetails) {
		this.propadEmpTechDetails = propadEmpTechDetails;
	}
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PropadEmpPerDetails getPropadEmpPerDetails() {
		return propadEmpPerDetails;
	}
	public void setPropadEmpPerDetails(PropadEmpPerDetails propadEmpPerDetails) {
		this.propadEmpPerDetails = propadEmpPerDetails;
	}
	
       
              
}
