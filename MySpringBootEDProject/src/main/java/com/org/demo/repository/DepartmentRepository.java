package com.org.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.demo.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer>{
	Optional<Department> findByStream(String stream);
}
