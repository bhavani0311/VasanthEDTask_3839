package com.org.demo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ED_EMPLOYEE_TABLE")
public class Employee {
	
	@Id
	private Integer employeeID;
	
	private String employeeName;
	
	private String address;
	
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfBirth;
	
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfJoining;
	
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfResignation;
	
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfLeaving;
	
	private String stream;
	
	private Integer DeptId;
	
	public Employee() {
		
	}
	
	public Employee(Integer employeeID, String employeeName, String address, Date dateOfBirth, Date dateOfJoining,
			Date dateOfResignation, Date dateOfLeaving, String stream) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.dateOfResignation = dateOfResignation;
		this.dateOfLeaving = dateOfLeaving;
		this.stream = stream;
	}

	public Employee(Integer employeeID, String employeeName, String address, Date dateOfBirth, Date dateOfJoining,
			Date dateOfResignation, Date dateOfLeaving, String stream, Integer deptId) {
		super();
		this.employeeID = employeeID;
		this.employeeName = employeeName;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.dateOfJoining = dateOfJoining;
		this.dateOfResignation = dateOfResignation;
		this.dateOfLeaving = dateOfLeaving;
		this.stream = stream;
		DeptId = deptId;
	}

	public Integer getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfResignation() {
		return dateOfResignation;
	}

	public void setDateOfResignation(Date dateOfResignation) {
		this.dateOfResignation = dateOfResignation;
	}

	public Date getDateOfLeaving() {
		return dateOfLeaving;
	}

	public void setDateOfLeaving(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public Integer getDeptId() {
		return DeptId;
	}

	public void setDeptId(Integer deptId) {
		DeptId = deptId;
	}
	
	
	
}
