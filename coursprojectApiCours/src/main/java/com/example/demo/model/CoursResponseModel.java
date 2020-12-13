package com.example.demo.model;

import com.example.demo.entity.CoursEntity;

public class CoursResponseModel {
	/*
	 * this class is meant to be a response of a cours demand
	 */
	private CoursEntity coursEntity;
	
	private Teacher teacher;

	public CoursEntity getCoursEntity() {
		return coursEntity;
	}

	public void setCoursEntity(CoursEntity coursEntity) {
		this.coursEntity = coursEntity;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
}
