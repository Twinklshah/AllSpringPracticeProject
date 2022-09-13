package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Department;

public interface DepartmentService {
	Department saveDepartment(Department dep);
	List<Department> fetchAllDepartment();
    Optional<Department> getDepartmentById(Long id);
	Department getProductByName(String name);
	String delDepartment(Long id);
}
