package com.alejandro.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alejandro.app.entity.Employee;
import com.alejandro.app.entity.User;
import com.alejandro.app.repository.UsersStatesCrudRepository;
import com.alejandro.app.services.EmployeeServiceIml;
import com.alejandro.app.services.UsersService;

@RestController
@RequestMapping("user")
public class UserRest {

	
	public UserRest(UsersStatesCrudRepository userService) {
		super();
		this.userService = userService;
	}

	@Autowired
	private UsersStatesCrudRepository userService;

	@GetMapping("/users")
	public Iterable<User> findAll() {
		return userService.findAll();
	}

}
