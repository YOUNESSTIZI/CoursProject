package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.CoursEntity;
import com.example.demo.model.CoursRequestModel;
import com.example.demo.service.CreateService.CoursCreationService;

@Controller
@RequestMapping("/cours")
public class CreateController {
	
	@Autowired
	private CoursCreationService coursService;
	
	@PostMapping()
	public ResponseEntity<CoursEntity> createCours(@Valid @ModelAttribute CoursRequestModel coursRequestModel) {
	
					
		CoursEntity coursEntity = this.coursService.create(coursRequestModel);
				
		return ResponseEntity.status(HttpStatus.CREATED).body(coursEntity);
	}
}
