package com.example.demo.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="inscription")
public class InscriptionEntity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="coursId",nullable=false)
	private int coursId;
	
		
	@Column(name="studentId",nullable=false)
	private String studentId;
	
	
	
	
	public InscriptionEntity() {
		super();
	}



	public InscriptionEntity( int coursId,  String studentId) {
		super();
		
		this.coursId = coursId;
		this.studentId = studentId;
		
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
		return "InscriptionEntity [id=" + id + ", coursId=" + coursId + ", StudentId=" + studentId + "]";
	}
	
	
	


	
	
	
	
}
