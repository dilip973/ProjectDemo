package com.bootapp.rest.restapp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bootapp.rest.restapp.model.Course;
import com.bootapp.rest.restapp.model.Instructor;
import com.bootapp.rest.restapp.model.InstructorCourse;
import com.bootapp.rest.restapp.service.CourseService;
import com.bootapp.rest.restapp.service.InstructorCourseService;
import com.bootapp.rest.restapp.service.InstructorService;

@RestController
@RequestMapping("/api/instructor/course")
public class InstructorCourseController {
    
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private InstructorService instructorService;
	
	@Autowired
	private InstructorCourseService instructorCourseService;
	
	
	@PostMapping("/add/{instructorId}/{courseId}")
	public ResponseEntity<String> assignInstructorToCourse(
			@RequestBody InstructorCourse instructorCourse,
			@PathVariable("courseId") int courseId,
			@PathVariable("instructorId") int instructorId) {
		
		
		Optional<Course> optionalC = courseService.getById(courseId);
		
		if(!optionalC.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Inavalid course Id given");
		
		// Fetch instructor object from instructorId
		
		Optional<Instructor> optionalI = instructorService.getInstructorById(instructorId);
		
		if(!optionalI.isPresent())
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Inavalid instructor Id given");
		
		Course course = optionalC.get();
		Instructor instructor = optionalI.get();
		
		instructorCourse.setCourse(course);
		
		instructorCourse.setInstructor(instructor);
		
		instructorCourseService.insert(instructorCourse);
		
		return ResponseEntity.status(HttpStatus.OK).body(" instructor asssigned to course");
		
		
		
	}
	
}
