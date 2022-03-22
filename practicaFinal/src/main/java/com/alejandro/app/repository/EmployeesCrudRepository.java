package com.alejandro.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alejandro.app.entity.Employee;
public interface EmployeesCrudRepository extends JpaRepository<Employee, Integer> {
	List<Employee> findAll();
}