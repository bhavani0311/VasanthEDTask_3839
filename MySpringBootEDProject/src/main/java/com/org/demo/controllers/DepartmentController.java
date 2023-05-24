package com.org.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.demo.entities.Department;
import com.org.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService deptService;
	
	@PostMapping("/saveDept")
	public Department saveDept(@RequestBody Department dept) {
		return deptService.saveDepartment(dept);
	}
	
	@GetMapping("/findDepartmentDetails/{deptId}")
	public String findDepartmentAndEmployees(@PathVariable Integer deptId) {
		return deptService.findDepartmentAndEmployees(deptId);
	}
	
	@PutMapping("/updateDepartmentById/{deptId}")
	public Department updateDepartmentById(@PathVariable Integer deptId,
			@RequestBody Department dept) {
		return deptService.updateDepartmentById(deptId, dept);
	}
	
	@DeleteMapping("/deleteDepartmentById/{deptId}")
	public void deleteDepartmentById(@PathVariable Integer deptId) {
		deptService.deleteDepartmentById(deptId);
	}
	
}
