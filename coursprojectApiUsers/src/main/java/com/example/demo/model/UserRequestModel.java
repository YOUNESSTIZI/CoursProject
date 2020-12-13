package com.example.demo.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.entity.Role;

public class UserRequestModel {
	/*
	 * this class is for the json file recieved to garantie that the object have the same attributs as the recieved
	 */
	@NotNull(message="the firstName shouldn't be null")
	private String firstName;
	
	@NotNull(message="the lastName shouldn't be null")
	private String lastName;
	
	@Email
	@NotNull(message="the email shouldn't be null")
	private String email;
	
	@Size(min=4,message="the password should be at least 4 caracters")
	private String password;
	
	@NotNull(message="the role shouldn't be null")
	@Enumerated(EnumType.STRING)
	private Role role;

	public UserRequestModel(String firstName,String lastName, String email,	 String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserRequestModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
	}
	
	
	

}
