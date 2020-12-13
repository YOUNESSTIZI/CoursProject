package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.entity.CoursEntity;

public interface CoursRepository extends CrudRepository<CoursEntity,Long>{
	
}
