package com.example.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/cours")
public class CoursController {
	
	
	@Autowired
	private Environment environment;
	
	
	
	@GetMapping("/status")
	public ResponseEntity<String> getStatus() {
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new String("Connextion etablished on Port:" + environment.getProperty("local.server.port") ));
	}
	



}
