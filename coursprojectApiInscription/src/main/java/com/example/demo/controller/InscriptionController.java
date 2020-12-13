package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.entity.InscriptionEntity;
import com.example.demo.entity.InscriptionResponseEntity;
import com.example.demo.model.InscriptionModel;
import com.example.demo.service.InscriptionService;



@Controller
@RequestMapping("/inscription")
public class InscriptionController {
	
	
	
	@Autowired
	private InscriptionService service;
	
	@GetMapping("/status")
	public ResponseEntity<String> getStatus() {
						
		String statut = service.getStatus();
		return ResponseEntity.status(HttpStatus.OK).body(statut);
	}
	
	
	@PostMapping()
	public ResponseEntity<InscriptionEntity> addStudent(@RequestBody InscriptionModel newInscription){				
		
		InscriptionEntity inscription = service.save(newInscription);	
		
		return ResponseEntity.status(HttpStatus.CREATED).body(inscription);
	}
	
	
	
	
	
	@GetMapping("/{coursId}")
	public ResponseEntity<InscriptionResponseEntity> getStudent(@PathVariable("coursId") int coursId){
		
		List<InscriptionEntity> inscriptions = service.getInscriptionsByCoursId(coursId);		
		
		InscriptionResponseEntity inscriptionResponse = service.getStudentsById(inscriptions);
		
		return ResponseEntity.status(HttpStatus.OK).body(inscriptionResponse);
		
	} 
	
}
