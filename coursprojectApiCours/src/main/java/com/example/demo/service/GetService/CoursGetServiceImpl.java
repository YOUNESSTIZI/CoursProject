package com.example.demo.service.GetService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.entity.CoursEntity;
import com.example.demo.model.CoursResponseModel;
import com.example.demo.model.Teacher;
import com.example.demo.repository.CoursRepository;

import javassist.NotFoundException;

@Service
public class CoursGetServiceImpl implements CoursGetService{
	
	@Autowired
	private CoursRepository coursRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment environnement;

	
	@Override
	public List<CoursResponseModel> getCours() throws NotFoundException{
		
		List<CoursEntity> cours = (List<CoursEntity>) this.coursRepository.findAll();
		
		if(cours == null ) throw new NotFoundException("cours Not Found");
		
		List<CoursResponseModel> coursResponseModel = new ArrayList<>();
		
		
		
		cours.forEach(cour -> {
			CoursResponseModel oneCoursResponse = new CoursResponseModel(); 
			oneCoursResponse.setCoursEntity(cour);
			try {
				
				Teacher teacher = this.getTeacherById(cour.getTeacherId());
				oneCoursResponse.setTeacher(teacher);
				
			}catch(NotFoundException exception){
				//to avoid the illegal assignement problems
				Teacher teacher = new Teacher();
				oneCoursResponse.setTeacher(teacher);
				
			}
		
						
			coursResponseModel.add(oneCoursResponse);
						
		});
		
		return coursResponseModel;
	}
	
	@Override
	public CoursResponseModel getCours(long id) throws NotFoundException {
		
		CoursResponseModel coursResponse = new CoursResponseModel();
		
		Optional<CoursEntity> coursEntity = this.coursRepository.findById(id);
		
		if(!coursEntity.isPresent()) {
			throw new NotFoundException("cours with id " + id + " not founded");
		}
		
		coursEntity.ifPresent(cours -> {
			coursResponse.setCoursEntity(cours);
			try {
				Teacher teacher = this.getTeacherById(cours.getTeacherId());
				coursResponse.setTeacher(teacher);
				
			}catch(NotFoundException exception) {
				//to avoid the exception of IllegalAssignementException
				Teacher teacher = new Teacher();
				coursResponse.setTeacher(teacher);
				
			}			
		});		

		return coursResponse;
	}
	
	
	@Override
	public Teacher getTeacherById(String teacherId) throws NotFoundException{
			
		String usersUrl = String.format(this.environnement.getProperty("userMicroservice.url") +"%s",teacherId);
		
		/*
		 * this line bellow will make connection with userMicroservice to connect to a controller! 
		 */
	
		ResponseEntity<Teacher> usersConnection = 
				this.restTemplate.exchange(usersUrl, HttpMethod.GET,null,
						new ParameterizedTypeReference<Teacher>() {});
		
		Teacher teacher = usersConnection.getBody();
		
		if(teacher == null) throw new NotFoundException("Teacher with id " + teacherId + "Not Found");
		
		return teacher;
		
	}

}
