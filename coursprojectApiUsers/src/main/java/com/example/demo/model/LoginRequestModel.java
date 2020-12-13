package com.example.demo.model;

public class LoginRequestModel {
	//this class is a model created for login in Jsons ! 
	private String email;
	private String password;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequestModel [email=" + email + ", password=" + password + "]";
	}
	
	
	

}
