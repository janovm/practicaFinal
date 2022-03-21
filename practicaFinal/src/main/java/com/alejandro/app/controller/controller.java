package com.alejandro.app.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alejandro.app.entity.Role;
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
				if (usuario.getRole().getId()==1) {
					ModelAndView model = new ModelAndView();
					model.setViewName("admin");
					System.out.println("admin");
					return model;
				}else if (usuario.getRole().getId()==2) {
					ModelAndView model = new ModelAndView();
					model.setViewName("advance");
					System.out.println("advance");
					return model;
				}else if (usuario.getRole().getId()==3) {
					ModelAndView model = new ModelAndView();
					System.out.println("normal");
					model.setViewName("normal");
					return model;
				}
			}
		}
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	
	@PostMapping("/addUser")
	public ModelAndView addUser(@RequestParam(value="username") String username, @RequestParam(value="password") String password, @RequestParam(value="rol") String rol) {
		User usuario = new User();
		usuario.setUser(username);
		usuario.setPassword(password);
		Role rolUser = new Role();
		rolUser.setId(Integer.parseInt(rol));
		usuario.setRole(rolUser);
		userService.save(usuario);
		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
		return model;
	}
}
