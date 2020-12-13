package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.model.CoursResponseModel;
import com.example.demo.service.GetService.CoursGetService;
import javassist.NotFoundException;

@Controller
@RequestMapping("/cours")
public class GetController {
	
	@Autowired
	private CoursGetService coursService;
	
	
	
	@GetMapping()
	public ResponseEntity<List<CoursResponseModel>> getCours(){
		
		List<CoursResponseModel> cours;
		try {
			
			cours =  this.coursService.getCours();
			
			return ResponseEntity.status(HttpStatus.OK).body(cours);
			
		} catch (NotFoundException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CoursResponseModel> getCours(@PathVariable int id){
		
		CoursResponseModel coursResponse;
		try {
			coursResponse = this.coursService.getCours(id);
			return ResponseEntity.status(HttpStatus.OK).body(coursResponse);
			
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
		}
		
		
	}

	
}
