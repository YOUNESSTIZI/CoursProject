package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.User;

public interface UsersRepository extends CrudRepository<User, Long> {

	//thanks to the framework , automatically we can make CRUDs with database
	
	User findByEmail(String email); // Spring framework will know it , we should just make the convention findBy+ attribute

	User findByUserId(String userId);
}
