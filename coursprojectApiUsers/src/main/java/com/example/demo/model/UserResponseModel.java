package com.example.demo.model;

import com.example.demo.entity.Role;

public class UserResponseModel {
	//cette class sera le model qu'on envoie comme réponse !
	
	private String firstName;
	private String lastName;
	private String email;
	private String userId;
	private Role role;
	
	
	
	
	
	public Role getRole() {
		return role;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public UserResponseModel() {
		
	}
	
	

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "UserResponseModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", userId="
				+ userId + "]";
	}
	
	

}
