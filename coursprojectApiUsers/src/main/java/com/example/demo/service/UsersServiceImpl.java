package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.model.UserResponseModel;
import com.example.demo.repository.UsersRepository;
import com.example.demo.sharedDto.UserDto;

import javassist.NotFoundException;



@Service
public class UsersServiceImpl implements UsersService {

	private UsersRepository userRepository;
	private BCryptPasswordEncoder pwdEncoder;
	
	@Autowired
	public  UsersServiceImpl(UsersRepository userRepository,BCryptPasswordEncoder pwdEncoder) {

		this.userRepository = userRepository ;
		this.pwdEncoder = pwdEncoder;
	}
	




	@Override
	public UserDto createUser(UserDto userDetails) {

		//this is the Id we should use to manipulate users Object , Database auto generated Id are not securised!
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(this.pwdEncoder.encode(userDetails.getPassword()));
	
		//map UserDto to UserEntity
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		User user = mapper.map(userDetails, User.class);
		
		//save the user into the database! 
		this.userRepository.save(user);
		
		UserDto returnValue = mapper.map(user,UserDto.class);
		
		
		return returnValue;
	}



	public UsersRepository getUserRepository() {
		return userRepository;
	}



	public void setUserRepository(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}





	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userRepository.findByEmail(email);
		
		if(user == null) throw new UsernameNotFoundException(email);	
		
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getEncryptedPassword(), true, true, true, true, new ArrayList<>());
	}
	
	@Override
	public UserDto getUserDetailsByEmail(String email) { 
		User userEntity = this.userRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		
		return new ModelMapper().map(userEntity, UserDto.class);
	}





	@Override
	public UserDto getUserById(String userId) {
		
		User userEntity = this.userRepository.findByUserId(userId);
		
		return new ModelMapper().map(userEntity, UserDto.class);
	}





	@Override
	public List<UserResponseModel> getUsers() throws NotFoundException {

		Iterable<User> usersEntities = this.userRepository.findAll();
		
		if(usersEntities == null ) throw new NotFoundException("users not found");
		
		List<UserResponseModel> usersResponse = new ArrayList<>();
		
		usersEntities.forEach(user -> {
			usersResponse.add(new ModelMapper().map(user, UserResponseModel.class));
		});
		
		return usersResponse;
	}









	

}
