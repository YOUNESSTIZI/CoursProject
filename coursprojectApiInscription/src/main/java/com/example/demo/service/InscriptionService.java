package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.InscriptionEntity;
import com.example.demo.entity.InscriptionResponseEntity;
import com.example.demo.model.InscriptionModel;
import com.example.demo.model.StudentModel;

public interface InscriptionService {

	StudentModel getStudentById(String studentId);

	String getStatus();

	InscriptionEntity save(InscriptionModel newInscription);

	List<InscriptionEntity> getInscriptionsByCoursId(int CoursId);

	InscriptionResponseEntity getStudentsById(List<InscriptionEntity> inscriptions);

}
