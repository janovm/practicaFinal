package com.alejandro.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alejandro.app.entity.Employee;
import com.alejandro.app.services.EmployeeServiceIml;

@RestController
@RequestMapping("app")
public class UserRest {

	@Autowired
	private EmployeeServiceIml employeeService;

	@GetMapping("/users")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/home")
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		return model;
	}
//
//	@GetMapping("/login")
//	public void recoger(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
//		System.out.println("DEBUG"+username+password);
//	}
	
	@Autowired
    private CacheManager cacheManager;      // autowire cache manager
    // clear all cache using cache manager
    @RequestMapping(value = "clearCache")
    public void clearCache(){
        for(String name:cacheManager.getCacheNames()){
            cacheManager.getCache(name).clear();            // clear cache by name
        }
    }

}
