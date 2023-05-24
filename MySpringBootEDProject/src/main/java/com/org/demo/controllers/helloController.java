package com.org.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.demo.entities.Department;
import com.org.demo.entities.Employee;
import com.org.demo.service.DepartmentService;
import com.org.demo.service.EmployeeService;

@RestController
public class helloController {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	
}
