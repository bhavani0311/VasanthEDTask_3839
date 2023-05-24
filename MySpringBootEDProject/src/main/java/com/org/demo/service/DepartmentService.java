package com.org.demo.service;

import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.org.demo.entities.Department;
import com.org.demo.entities.Employee;

public interface DepartmentService {
	
	public Department saveDepartment(Department dept);
	
	public Optional<Department> findByStream(String stream);
	
	public String findDepartmentAndEmployees(Integer deptId);
	
	public Department updateDepartmentById(Integer deptId,Department dept);
	
	public void deleteDepartmentById(Integer deptId);

}
