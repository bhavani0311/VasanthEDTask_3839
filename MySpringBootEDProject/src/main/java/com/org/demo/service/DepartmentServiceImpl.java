package com.org.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.org.demo.entities.Department;
import com.org.demo.entities.Employee;
import com.org.demo.repository.DepartmentRepository;
import com.org.demo.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	DepartmentRepository deptRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@Override
	public Department saveDepartment(Department dept) {
		return deptRepo.save(dept);
	}

	public Optional<Department> findByStream(String stream) {
		// TODO Auto-generated method stub
		return deptRepo.findByStream(stream);
	}
	
	public String findDepartmentAndEmployees(Integer deptId) {
		
		Department dept = deptRepo.findById(deptId).get();
		List<Employee> emp = empRepo.findAll();
		String s="";
		for(Employee e:emp) {
			if(e.getDeptId()==deptId)
			s = s+" "+e.getEmployeeID();
		}
		return "Based on Department Id as per records name of department is "
				+ dept.getDepartmentName()+" and employees associated with that department "
						+ "are "+s;
	}
	public Department updateDepartmentById( Integer deptId, Department dept) {
		
		Department d = deptRepo.findById(deptId).get();
		
		if(dept.getDepartmentName()!=null)
			d.setDepartmentName(dept.getDepartmentName());
		
		deptRepo.save(d);
		
		return d;
		
	}
	//Delete department and assign that emp to Bench
	public void deleteDepartmentById(Integer deptId) {
		
		List<Employee> emp = empRepo.findAll();
		for(Employee e:emp) {
			if(e.getDeptId()==deptId) {
				e.setDeptId(0);
				e.setStream("BENCH");
				empRepo.save(e);
			}
		}
		deptRepo.deleteById(deptId);
	}

}
