package com.example.demo;

import java.io.Serializable;

public class EmailProperties implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 95601L;
	
	private String from;
	//private String[] to; //For Group recepients
	private String to;
	private String subject;
	private String body;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to=to;
	}

	
	  /*public String[] getTo() { return to; 
	  } 
	  public void setTo(String[] to) 
	  {
	  this.to = to;
	  } */ // For Group recepients
	 
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	

}
