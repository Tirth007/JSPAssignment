package com.sterlite.employee;

import java.math.BigInteger;

public class User {
	private String username;
	private String password;
	private String emailId;
	private BigInteger mobileNumber;
	private String address;
	private String designation;
	
	public User(String username,String password, String emailId, BigInteger mobilenumber, 
			String address, String designation) {
		this.username = username;
		this.password = password;
		this.emailId = emailId;
		this.mobileNumber = mobilenumber;
		this.address = address;
		this.designation = designation;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public BigInteger getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
}
