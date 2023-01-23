package com.bootapp.rest.restapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Course;
import com.bootapp.rest.restapp.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	/* Course Post API*/
	@PostMapping("/add/course")
	public ResponseEntity<String> postCourse(@RequestBody Course course){
		courseService.postCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body("Course posted in DB");
	}
	/* Get All API */
	@GetMapping("/allcourse")
	public List<Course> getAllCourses(){
		List<Course> list = courseService.getAllCourses();
		return list;
	}
	/* Get by ID*/
	@GetMapping("/one/course/{id}")
	public ResponseEntity<Object> getById(@PathVariable("id")int id){
		Optional<Course> optional = courseService.getById(id);
		if(optional == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID Given");
		
		Course course = optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(course);
	}
}