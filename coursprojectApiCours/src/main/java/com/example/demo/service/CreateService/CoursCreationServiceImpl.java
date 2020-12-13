package com.example.demo.service.CreateService;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CoursEntity;
import com.example.demo.model.CoursRequestModel;

import com.example.demo.repository.CoursRepository;



@Service
public class CoursCreationServiceImpl implements CoursCreationService {
	
	/*
	 * this service is used to create courses and save them in the database !
	 */
	
	@Autowired
	private ModelMapper mapper ;
	
	@Autowired 
	private CoursRepository coursRepository;
	
	
	

	@Override
	public CoursEntity create(CoursRequestModel coursRequestModel) {
		
		String imageId = ImageLocation.saveImage(coursRequestModel.getImageFile());
		
		CoursEntity coursEntity = this.mapper.map(coursRequestModel,CoursEntity.class);
		coursEntity.setImageId(imageId);
		coursEntity.setTeacherId(coursRequestModel.getTeacherId());
		
		
		this.coursRepository.save(coursEntity);
		
		return coursEntity;
		
	}



}
