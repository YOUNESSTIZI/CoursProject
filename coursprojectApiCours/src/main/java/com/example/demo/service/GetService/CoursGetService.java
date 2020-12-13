package com.example.demo.service.GetService;

import java.util.List;

import com.example.demo.model.CoursResponseModel;
import com.example.demo.model.Teacher;
import com.example.demo.service.*;

import javassist.NotFoundException;



public interface CoursGetService extends CoursService{
	
	public List<CoursResponseModel> getCours() throws NotFoundException;
	
	public CoursResponseModel getCours(long id) throws NotFoundException;
	
	public Teacher getTeacherById(String id) throws NotFoundException;
	
}
