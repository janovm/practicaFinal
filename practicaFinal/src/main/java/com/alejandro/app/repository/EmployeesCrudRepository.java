package com.alejandro.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.alejandro.app.entity.Employee;


public interface EmployeesCrudRepository extends CrudRepository<Employee, Integer> {
	
	
}