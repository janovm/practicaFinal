package com.alejandro.app.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import com.alejandro.app.entity.Employee;
import com.alejandro.app.repository.EmployeesCrudRepository;

@Service
public class EmployeeServiceIml {

	@Autowired
	private final EmployeesCrudRepository employeeDAO;

	public EmployeeServiceIml(EmployeesCrudRepository employeeDAO) {
		super();
		this.employeeDAO = employeeDAO;
	}

	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	public void delete(Employee employee) {
		employeeDAO.delete(employee);
	}

	public void save(Employee employee) {
		employeeDAO.save(employee);
	}
}
