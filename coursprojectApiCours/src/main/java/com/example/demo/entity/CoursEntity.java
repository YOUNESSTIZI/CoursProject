package com.example.demo.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cours")
public class CoursEntity implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title",nullable=false)
	private String title;
	
	@Column(name="description",nullable=false)
	private String description;
	
	@Column(name="imageId")
	private String imageId;
	
		
	@Column(name="teacherId",nullable=false)
	private String teacherId;
	
	
	
	public CoursEntity() {
		
	}
	
	public CoursEntity( String title, String description, String imageId, String teacherId,
			String studentsInscritsId) {
		super();
		this.title = title;
		this.description = description;
		this.imageId = imageId;
		this.teacherId = teacherId;
	}

	public long getId() {
		return id;
	}

	
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

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	

	@Override
	public String toString() {
		return "CoursEntity [id=" + id + ", title=" + title + ", description=" + description + ", imageUrl=" + imageId
				+ "," +  ", teacherId=" + teacherId + ", studentsInscritsId=" 
				+ "]";
	}
	
	
	
}
