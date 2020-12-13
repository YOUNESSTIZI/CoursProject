package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.UserResponseModel;
import com.example.demo.sharedDto.UserDto;

import javassist.NotFoundException;

public interface UsersService extends UserDetailsService {
	
	public UserDto createUser(UserDto userDetails);
	
	
	public UserDto getUserDetailsByEmail(String email) ;

	
	public UserDto getUserById(String userId);


	public List<UserResponseModel> getUsers() throws NotFoundException;

}
