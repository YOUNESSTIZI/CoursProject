package com.example.demo.service.DeleteService;


import com.example.demo.entity.CoursEntity;
import com.example.demo.service.CoursService;

import javassist.NotFoundException;

public interface CoursDeleteService extends CoursService {

	public CoursEntity deleteCours(long id) throws NotFoundException;

}
