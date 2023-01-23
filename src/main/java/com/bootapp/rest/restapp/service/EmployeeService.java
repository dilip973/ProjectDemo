package com.bootapp.rest.restapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootapp.rest.restapp.data.EmployeeRepository;
import com.bootapp.rest.restapp.model.Employee;

@Service
public class EmployeeService {
        
	
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	public void postEmployee(Employee employee) {
		// save employee in DB 
		employeeRepository.save(employee);
}

	public List<Employee> getEmployeeByDepartmentId(int did) {
		List<Employee> list =employeeRepository.findAll();
				
		List<Employee> filteredList= list.stream()
				        .filter(e -> e.getDepartment().getId()== did)
                        .collect(Collectors.toList());
		
		
		return filteredList;
	}
	
	public List<Employee> getEmployeesBySalaryAndCity(double salary,String city){
		
		List<Employee> list =employeeRepository.findAll();
		List<Employee> filtereddata=list.stream()
				.filter(e -> e.getSalary() > salary)
				.filter(e -> e.getCity().equals(city))
				.collect(Collectors.toList());
		return filtereddata;
	}
	}
