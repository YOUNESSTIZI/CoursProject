package com.example.demo.model;

import java.io.Serializable;

public class InscriptionModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int coursId;
	private String studentId;
	
	public InscriptionModel() {
		super();
	}
	
	public int getCoursId() {
		return coursId;
	}
	public void setCoursId(int coursId) {
		this.coursId = coursId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "InscriptionModel [coursId=" + coursId + ", studentId=" + studentId + "]";
	}
	
	
	
}
