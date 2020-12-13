package com.example.demo.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entity.InscriptionEntity;
import com.example.demo.entity.InscriptionResponseEntity;
import com.example.demo.model.InscriptionModel;
import com.example.demo.model.StudentModel;
import com.example.demo.repository.*;

@Service
public class InscriptionServiceImpl implements InscriptionService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private InscriptionRepository InscriptionRepository;
	
	@Override
	public StudentModel getStudentById(String studentId) {
		
		String usersUrl = String.format("http://USERS-WS/users/%s",studentId);
		
		ResponseEntity<StudentModel> usersConnection = 
				this.restTemplate.exchange(usersUrl, HttpMethod.GET,null,
						new ParameterizedTypeReference<StudentModel>() {});
		
		return usersConnection.getBody();
		
	}
	
	@Override
	public String getStatus() {
		
		String coursUrl = "http://COURS-WS/cours/status";		
		ResponseEntity<String> coursConnection =
				this.restTemplate.exchange(coursUrl, HttpMethod.GET,null,
						new ParameterizedTypeReference<String>() {});
		
		return coursConnection.getBody();
	}
	


	@Override
	public InscriptionEntity save(InscriptionModel newInscription) {
		
		ModelMapper mapper = new ModelMapper();
		
		InscriptionEntity inscriptionEntity= mapper.map(newInscription,InscriptionEntity.class);
		
		this.InscriptionRepository.save(inscriptionEntity);
		
		return inscriptionEntity;
	}

	@Override
	public List<InscriptionEntity> getInscriptionsByCoursId(int coursId) {
		
		List<InscriptionEntity> inscriptions = this.InscriptionRepository.findAllByCoursId(coursId);
		
		return inscriptions;
	}

	@Override
	public InscriptionResponseEntity getStudentsById(List<InscriptionEntity> inscriptions) {
		
		if(inscriptions == null ) {
			return null;
		}
		
		InscriptionResponseEntity inscriptionResponse = new InscriptionResponseEntity();
		
		
		
		//then we add students one by one after getting them from the User MicroService
		inscriptions.forEach(inscription -> {
			
			String studentId = inscription.getStudentId();
			
			//System.out.print(studentId);
			StudentModel student = getStudentById(studentId);
			
			inscriptionResponse.addStudentRegistred(student);
			inscriptionResponse.setCoursId(inscription.getCoursId());
			
		});
		
		return inscriptionResponse;
	}

	




}
