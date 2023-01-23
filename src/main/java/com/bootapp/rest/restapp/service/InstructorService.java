package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.InstructorRepository;
import com.bootapp.rest.restapp.model.Instructor;
@Service
public class InstructorService {

	
	@Autowired
	private InstructorRepository instructorRepository;
	
	public void insertEmployee(Instructor instructor) {
		instructorRepository.save(instructor);
	}
	public List<Instructor> getAllInstructors() {
		return instructorRepository.findAll();
		
		
	}
	public void postInstructor(Instructor instructor) {
		// save employee in DB 
		instructorRepository.save(instructor);
}
	public Optional<Instructor> getInstructorById(int id) {
		
		Optional<Instructor>  optional =instructorRepository.findById(id);
		
		return optional;
	}

}
