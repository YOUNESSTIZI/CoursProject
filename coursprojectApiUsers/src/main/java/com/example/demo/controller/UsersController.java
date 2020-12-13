package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserRequestModel;
import com.example.demo.model.UserResponseModel;
import com.example.demo.service.UsersService;
import com.example.demo.sharedDto.UserDto;
import com.thoughtworks.xstream.mapper.Mapper;

import javassist.NotFoundException;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	
	@Autowired
	private Environment env; //to retrieve Port Information
	
	@Autowired
	private UsersService service;
	
	
	@GetMapping("/status")
	public String getStatus() {
		return "working .. on port : " + env.getProperty("local.server.port") ;
	}
	
	
	/*
	 * the valid annotation below will make sure that all the verification are done with success(@NotNull @Email),otherwise it will reject the request
	 */
	
	@PostMapping
	public ResponseEntity<UserResponseModel> createUser(@Valid @RequestBody UserRequestModel userRequestModel) {
		
		//map UserRequestModel to UserDto
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDto userDto = mapper.map(userRequestModel, UserDto.class);
		
		UserDto returnValue = service.createUser(userDto); // this method will generate a userId !
		
		UserResponseModel responseUser = mapper.map(returnValue, UserResponseModel.class); 
		return  ResponseEntity.status(HttpStatus.CREATED).body(responseUser); 
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId){
		
		UserDto user = service.getUserById(userId);
		
		ModelMapper mapper = new ModelMapper();
		UserResponseModel responseUser = mapper.map(user,UserResponseModel.class);
		
		return  ResponseEntity.status(HttpStatus.OK).body(responseUser);
	}
	
	@GetMapping()
	public ResponseEntity<List<UserResponseModel>> getUsers(){
		List<UserResponseModel> users ;
		try {
			users = service.getUsers();
			
		}catch(NotFoundException e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

		}
		
		return ResponseEntity.status(HttpStatus.OK).body(users);

	}

}












