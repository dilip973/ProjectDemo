package com.bootapp.rest.restapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
public class InstructorCourse {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@ManyToOne
	private Instructor instructor;
	
	@ManyToOne
	private Course course; 
	
	//2 ManyTOOne combined together make ManyToMany
	
	private String batch; 
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String year;

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	

	
	

}
