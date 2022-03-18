package com.alejandro.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alejandro.app.entity.Employee;
import com.alejandro.app.repository.EmployeesCrudRepository;

@Service
public class EmployeeServiceIml {
	
	@Autowired
	private EmployeesCrudRepository employeeDAO;

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		employeeDAO.findAll();
		return null;
	}

}
