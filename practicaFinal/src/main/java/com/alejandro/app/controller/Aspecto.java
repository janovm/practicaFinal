package com.alejandro.app.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import com.alejandro.app.entity.Employee;
import com.alejandro.app.repository.EmployeesCrudRepository;
import com.alejandro.app.services.EmployeeServiceIml;

@Aspect
@Configuration
public class Aspecto {

	private final EmployeeServiceIml employeesService;
	
	
	
	public Aspecto(EmployeeServiceIml employeesService) {
		super();
		this.employeesService = employeesService;
	}



	@Before(value = "execution(* com.alejandro.app.controller.Controlador.checkEmpleados(..))")
	public void sentenciaLogBefore(JoinPoint punto) {

		System.out.println(employeesService.findAll().get(0).getNombre().toString());
		List<Employee> empleados = employeesService.findAll();
		for (Iterator iterator = empleados.iterator(); iterator.hasNext();) {
			Employee employee = (Employee) iterator.next();
			if (employee.getFecha_baja()!=null) {
				employeesService.delete(employee);
			}
		}
	}

}
