package com.example.demo.service.DeleteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CoursEntity;
import com.example.demo.repository.CoursRepository;
import com.example.demo.service.GetService.CoursGetService;

import javassist.NotFoundException;

@Service
public class CoursDeleteServiceImpl implements CoursDeleteService {
	
	@Autowired
	private CoursRepository coursRepository;
	
	@Autowired
	private CoursGetService coursGetService;
	
		
	@Override
	public CoursEntity deleteCours(long id) throws NotFoundException {
				
					
			CoursEntity coursEntity = this.coursGetService.getCours(id).getCoursEntity();
			
			this.coursRepository.delete(coursEntity);
			
			
			return coursEntity;
			
			
	}	
		
}
