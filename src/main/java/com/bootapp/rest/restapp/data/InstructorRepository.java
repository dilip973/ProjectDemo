package com.bootapp.rest.restapp.data;

import org.springframework.data.jpa.repository.JpaRepository;


import com.bootapp.rest.restapp.model.Instructor;

public interface InstructorRepository extends JpaRepository <Instructor, Integer>{
	
}


