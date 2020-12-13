package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.InscriptionEntity;


public interface InscriptionRepository extends CrudRepository<InscriptionEntity,Long>{ 
	
	public List<InscriptionEntity> findAllByCoursId(int coursId);

}
