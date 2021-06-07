package com.hms.userservice.models;

public class Users {

	private String username;
	private String pass;
	private String userType;
	private String email;
	
	
	
	
	
	public Users(String username, String pass, String userType, String email) {
		super();
		this.username = username;
		this.pass = pass;
		this.userType = userType;
		this.email = email;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
