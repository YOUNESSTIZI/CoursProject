package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.StudentModel;

public class InscriptionResponseEntity {
	
	private int coursId;
	private List<StudentModel> studentsRegistred;
	
	
	public int getCoursId() {
		return coursId;
	}
	public void setCoursId(int coursId) {
		this.coursId = coursId;
	}
	public List<StudentModel> getStudentsRegistred() {
		return studentsRegistred;
	}
	public void setStudentsRegistred(List<StudentModel> studentsRegistred) {
		this.studentsRegistred = studentsRegistred;
	}
	
	public void addStudentRegistred(StudentModel student) {
		if(this.studentsRegistred == null) {
			this.studentsRegistred = new ArrayList<StudentModel>();
		}
		this.studentsRegistred.add(student);
	}
	
	
}
