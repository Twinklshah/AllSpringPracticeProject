package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

	List<Department> findByDepartmentName(String nameDepartment);
	
	List<Department> findByDepartmentHead(String departmentHead);

    List<Department> findByIsActive(Boolean isActive);

}