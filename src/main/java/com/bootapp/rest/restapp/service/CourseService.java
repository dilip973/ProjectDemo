package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.CourseRepository;
import com.bootapp.rest.restapp.model.Course;


@Service
public class CourseService {

	@Autowired
	private CourseRepository courseRepository;
	
	public void postCourse(Course course) {
		// save course in DB 
		courseRepository.save(course);
}
	
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
		
		
	}
	
	public Optional<Course> getById(int courseId) {
		
		Optional<Course> optional =courseRepository.findById(courseId);
		
		return optional;
	}

	

	

}