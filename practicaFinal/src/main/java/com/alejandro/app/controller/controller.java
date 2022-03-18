package com.alejandro.app.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alejandro.app.entity.User;
import com.alejandro.app.repository.UsersStatesCrudRepository;

@Controller
public class controller {
	
	@Autowired
	private UsersStatesCrudRepository userService;
	
	@GetMapping("/home")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

	@PostMapping("/login")
	public ModelAndView recoger(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
		Iterable<User> usuarios = userService.findAll();
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			User usuario = (User) iterator.next();
			if (usuario.getUser().equalsIgnoreCase(username) && usuario.getPassword().equalsIgnoreCase(password)) {
				ModelAndView model = new ModelAndView();
				model.setViewName("usuario");
				return model;
			}
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
}
