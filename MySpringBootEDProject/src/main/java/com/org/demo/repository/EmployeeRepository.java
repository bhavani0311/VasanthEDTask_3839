package com.org.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.demo.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	       
}
