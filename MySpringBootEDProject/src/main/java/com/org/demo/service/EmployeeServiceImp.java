package com.org.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.text.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.org.demo.entities.Department;
import com.org.demo.entities.Employee;
import com.org.demo.repository.DepartmentRepository;
import com.org.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	@Autowired
	DepartmentRepository deptRepo;

	public static String JAVA_PRATICE = "JAVA";

	public static String PYTHON_PRATICE = "PYTHON";

	public static String ORACLE_PRATICE = "ORACLE";

	ArrayList<String> listOfStreams = new ArrayList<String>(
			Arrays.asList(JAVA_PRATICE, PYTHON_PRATICE, ORACLE_PRATICE));

	@Override
	public Employee saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		ArrayList<String> listOfStreams = new ArrayList<String>(
				Arrays.asList(JAVA_PRATICE, PYTHON_PRATICE, ORACLE_PRATICE));
		Boolean isPresent = false;
		for (String stream : listOfStreams) {
			if (emp.getStream() != null && !emp.getStream().isEmpty() && emp.getStream().equalsIgnoreCase(stream)) {

				Optional<Department> deptOpt = deptRepo.findByStream(stream);
				if (!deptOpt.isEmpty()) {
					Department dept = deptOpt.get();
					emp.setDeptId(dept.getDepartmentId());
					isPresent = true;

				}

			}
			if (!isPresent)
				emp.setDeptId(0);
		}

		return empRepo.save(emp);
	}

	// findEmployees
	public ArrayList<String> findEmployees() {

		List<Employee> listOfEmployees = empRepo.findAll();

		ArrayList<String> employees = new ArrayList<String>();

		for (Employee emp : listOfEmployees) {

			Optional<Department> deptOpt = deptRepo.findById(emp.getDeptId());

			Department dept = new Department();

			if (!deptOpt.isEmpty()) {
				dept = deptOpt.get();
			} else {
				dept.setDepartmentId(0);
				dept.setDepartmentName("ON BENCH");
			}

			employees.add("Employee bearing ID " + emp.getEmployeeID() + " and name " + emp.getEmployeeName()
					+ " is allocated to Department named as " + dept.getDepartmentName() + " whose DepartmentId is "
					+ dept.getDepartmentId());
		}
		return employees;

	}

	// findEmployeeById
	public String findEmployeeById(Integer empId) {
		Optional<Employee> optEmp = null;
		if (empId != null) {
			optEmp = empRepo.findById(empId);
			if (optEmp.isEmpty())
				return "Cant find a employee with this employeeID";
			Employee emp = optEmp.get();
			Department dept = deptRepo.findById(emp.getDeptId()).get();
			return "Employee bearing ID " + emp.getEmployeeID() + " and name " + emp.getEmployeeName()
					+ " is in Department named as " + dept.getDepartmentName() + " whose DepartmentId is "
					+ dept.getDepartmentId();
		} else {
			return "Please enter employeeID";
		}

	}

	// updateEmployees
	public Employee updateEmployee(Employee emp) {
		Optional<Employee> empOpt = empRepo.findById(emp.getEmployeeID());
		if (!empOpt.isEmpty() && empOpt != null) {
			Employee e = empOpt.get();
			e.setDateOfBirth(emp.getDateOfBirth());
			e.setAddress(emp.getAddress());
			e.setDateOfJoining(emp.getDateOfJoining());
			e.setDateOfResignation(emp.getDateOfResignation());
			e.setDateOfLeaving(emp.getDateOfLeaving());
			e.setStream(emp.getStream());
			empRepo.save(e);
			return e;
		} else {
			Employee e = null;
			return emp;
		}
	}

	// deleteEmpById
	public String deleteEmployeeById(Integer empId) {
		empRepo.deleteById(empId);
		return "record got deleted";
	}

	// update Employees With DOL
	public String updateEmployees() {

		List<Employee> listOfEmployees = empRepo.findAll();
		int count = 0;
		for (Employee emp : listOfEmployees) {
			if (emp.getDateOfResignation() != null && emp.getDateOfLeaving() == null) {
				LocalDate DOL = LocalDate.now().plusDays(30);
				Date date = Date.from(DOL.atStartOfDay(ZoneId.systemDefault()).toInstant());
				emp.setDateOfLeaving(date);
				count++;
				empRepo.save(emp);
			}
		}
		return "Number of Employees whose Date Of Leaving is declared is" + count;
	}

	// Delete employees whose DOR is today
	public String deleteEmployeeByResignationDate() {

		List<Employee> listOfEmployees = empRepo.findAll();
		Date date = new Date();
		Date date_1 = null;
		int count = 0;
		String s = "";
		for (Employee emp : listOfEmployees) {

			if (emp.getDateOfLeaving() != null) {
				try {
					date_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(emp.getDateOfLeaving().toString());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				if (emp.getDateOfLeaving().before(date)) {
					empRepo.deleteById(emp.getEmployeeID());
					count++;
				}

			}
		}
		return "All employees whose last working is passed is removed from "
				+ "company and number of employees left are  " + count;
	}

}
