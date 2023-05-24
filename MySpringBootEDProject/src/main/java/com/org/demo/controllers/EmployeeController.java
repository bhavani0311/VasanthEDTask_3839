package com.org.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.demo.entities.Employee;
import com.org.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	@PostMapping("/saveEmp")
	public Employee saveEmp(@RequestBody Employee emp) {
		return empService.saveEmp(emp);
	}
	
	@GetMapping("/findAllEmployees")
	public ArrayList<String> findEmployees() {
		return empService.findEmployees();
	}
	
	@GetMapping("/findByEmployeeId/{empId}")
	public String findEmployeeById(@PathVariable Integer empId) {
		return empService.findEmployeeById(empId);	
	}
	
	@PutMapping("/updateEmployee")
	public Employee updateEachEmployee(@RequestBody Employee emp) {
		return empService.updateEmployee(emp);
	}
	
	@DeleteMapping("/deleteEmployeeById/{empId}")
	public String deleteEmployeeById(@PathVariable Integer empId) {
		return empService.deleteEmployeeById(empId);
	}
	
	@Scheduled(fixedDelayString = "PT24H", initialDelay=2000L)
	@PutMapping("/updateEmployeesWithResignationDate")
	public String updateEmployees(){
		return empService.updateEmployees();
	}
	
	@Scheduled(fixedDelayString = "PT24H", initialDelay=2000L)
	@DeleteMapping("/Synjob")
	public String syncEmpTable() {
		 return empService.deleteEmployeeByResignationDate();
	}
}
