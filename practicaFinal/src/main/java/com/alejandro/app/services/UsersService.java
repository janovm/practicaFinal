package com.alejandro.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alejandro.app.entity.Employee;
import com.alejandro.app.repository.UsersStatesCrudRepository;

@Service
public class UsersService {
	
	@Autowired
	private UsersStatesCrudRepository usersDAO;

	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		usersDAO.findAll();
		return null;
	}
}
