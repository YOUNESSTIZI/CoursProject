package com.example.demo.model;


import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class CoursRequestModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	//this class represent the request model ! means the object received from the client on creating 
	@NotNull(message="the title shouldn't be null")
	private String title;
	
	
	private String description;
	
	
	private MultipartFile imageFile;
	
	private String teacherId;
	
	
	



	public String getTeacherId() {
		return teacherId;
	}


	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}




	public MultipartFile getImageFile() {
		return imageFile;
	}


	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}




	@Override
	public String toString() {
		return "CoursRequestModel [title=" + title + ", description=" + description + ", imageFile=" + imageFile
				+  "]";
	}
	
	

	
	
}
