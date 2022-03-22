package com.alejandro.app.controller;

import java.sql.Date;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alejandro.app.entity.Employee;
import com.alejandro.app.entity.Role;
import com.alejandro.app.entity.User;
import com.alejandro.app.repository.EmployeesCrudRepository;
import com.alejandro.app.repository.UsersStatesCrudRepository;
import com.alejandro.app.services.EmployeeServiceIml;
import com.alejandro.app.services.Encript;

@Controller
public class Controlador {
	
	@Autowired
	private UsersStatesCrudRepository userService;
	@Autowired
	private EmployeeServiceIml employeeService;
	private Encript encriptador;
	
	@GetMapping("/home")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

	@PostMapping("/login")
	public ModelAndView recoger(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
		Iterable<User> usuarios = userService.findAll();
		encriptador = new Encript();
		for (Iterator iterator = usuarios.iterator(); iterator.hasNext();) {
			User usuario = (User) iterator.next();
			if (usuario.getUser().equalsIgnoreCase(username) && usuario.getPassword().equalsIgnoreCase(encriptador.getAES(password))) {
				if (usuario.getRole().getId()==1) {
					ModelAndView model = new ModelAndView();
					model.setViewName("admin");
					model.addObject("listaUsers",userService.findAll());
					model.addObject("listaEmployeers",employeeService.findAll());
					System.out.println("admin");
					return model;
				}else if (usuario.getRole().getId()==2) {
					ModelAndView model = new ModelAndView();
					model.setViewName("advance");
					model.addObject("listaUsers",userService.findAll());
					model.addObject("listaEmployeers",employeeService.findAll());
					System.out.println("advance");
					return model;
				}else if (usuario.getRole().getId()==3) {
					ModelAndView model = new ModelAndView();
					System.out.println("normal");
					model.addObject("listaUsers",userService.findAll());
					model.addObject("listaEmployeers",employeeService.findAll());
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
		encriptador = new Encript();
		usuario.setPassword(encriptador.getAES(password));
		Role rolUser = new Role();
		rolUser.setId(Integer.parseInt(rol));
		usuario.setRole(rolUser);
		userService.save(usuario);
		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
		model.addObject("listaUsers",userService.findAll());
		model.addObject("listaEmployeers",employeeService.findAll());
		return model;
	}
	
	@PostMapping("/addEmployeer")
	public ModelAndView addEmployee(@RequestParam(value="apellidos") String apellidos, @RequestParam(value="dni") String dni, @RequestParam(value="fecha_alta") Date fecha_alta, @RequestParam(value="fecha_baja") Date fecha_baja,  @RequestParam(value="identificador") String identificador, @RequestParam(value="nombre") String nombre,  @RequestParam(value="jornadas") String jornadasId) {
		Employee empleado = new Employee();
		empleado.setApellidos(apellidos);
		empleado.setDni(dni);
		empleado.setFecha_alta(fecha_alta);
		empleado.setFecha_baja(fecha_baja);
		empleado.setIdentificador(identificador);
		employeeService.save(empleado);
		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
		model.addObject("listaUsers",userService.findAll());
		model.addObject("listaEmployeers",employeeService.findAll());
		return model;
	}
	
	@RequestMapping("/deleteUser")
	public ModelAndView deleteUser(@RequestParam(value="userId") Integer id) {
		User usuario = new User();
		usuario.setId(id);
		userService.delete(usuario);
		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
		model.addObject("listaUsers",userService.findAll());
		model.addObject("listaEmployeers",employeeService.findAll());
		return model;
	} 
	
	@RequestMapping("/checkEmpleados")
	public ModelAndView checkEmpleados() {
		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
		model.addObject("listaUsers",userService.findAll());
		model.addObject("listaEmployeers",employeeService.findAll());
		return model;
	}
	
	@RequestMapping("/modifyUser")
	public ModelAndView deleteUser(@RequestParam(value="userId") String id, @RequestParam(value="user") String username, @RequestParam(value="passw") String password, @RequestParam(value="enabled") String enabled) {
		User usuario = new User();
		usuario.setId(Integer.parseInt(id));
		userService.delete(usuario);
		usuario.setUser(username);
		usuario.setPassword(password);
		usuario.setEnabled(Integer.parseInt(enabled));
		userService.save(usuario);
		ModelAndView model = new ModelAndView();
		model.setViewName("admin");
		model.addObject("listaUsers",userService.findAll());
		model.addObject("listaEmployeers",employeeService.findAll());
		return model;
	}
	
}
