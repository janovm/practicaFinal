package com.alejandro.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.alejandro.app.entity.Employee;


public interface EmployeesCrudRepository extends JpaRepository<Employee, Integer> {
	
}