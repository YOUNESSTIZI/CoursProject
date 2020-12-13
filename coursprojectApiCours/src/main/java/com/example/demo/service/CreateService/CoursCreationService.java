package com.example.demo.service.CreateService;

import com.example.demo.entity.CoursEntity;
import com.example.demo.model.CoursRequestModel;
import com.example.demo.service.CoursService;

public interface CoursCreationService extends CoursService {

	public CoursEntity create(CoursRequestModel coursRequestModel);
}
