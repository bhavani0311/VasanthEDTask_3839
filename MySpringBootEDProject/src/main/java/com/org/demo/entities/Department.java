package com.org.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ED_DEPARTMENT_TABLE")
public class Department {
	
	@Id
	private Integer departmentId;
	
	private String departmentName;
	
	private String stream;
	
	public Department() {
		
	}

	

	public Department(Integer departmentId, String departmentName, String stream) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.stream = stream;
		//this.employees = employees;
	}



	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}
	/*
	public List<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}*/

	
	
	
	
}
