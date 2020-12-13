package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.CoursEntity;
import com.example.demo.service.DeleteService.CoursDeleteService;

import javassist.NotFoundException;

@Controller
@RequestMapping("/cours/delete")
public class DeleteController {

	@Autowired
	private CoursDeleteService coursService;

	@GetMapping("/{id}")
	public ResponseEntity<Object> deleteCours(@PathVariable int id) {
		
		CoursEntity coursEntity;
		try {
			
			coursEntity = this.coursService.deleteCours(id);			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(coursEntity);
			
		} catch (NotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
		
	}

}
