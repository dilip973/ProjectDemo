package com.bootapp.rest.restapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.InstructorCourseRepository;
import com.bootapp.rest.restapp.model.InstructorCourse;

@Service
public class InstructorCourseService {

	
	@Autowired
	private InstructorCourseRepository instructorCourseRepository;
	
	public void insert(InstructorCourse instructorCourse) {
		
		instructorCourseRepository.save(instructorCourse);
	}

	
}
