package com.org.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.org.demo.entities.Employee;

public interface EmployeeService {
	
	public Employee saveEmp(Employee emp);
	
	public ArrayList<String> findEmployees();
	
	public String findEmployeeById(Integer empId);
	
	public Employee updateEmployee(Employee emp);
	
	public String deleteEmployeeById(Integer empId);
	
	public String deleteEmployeeByResignationDate();
	
	public String updateEmployees();

	
}
