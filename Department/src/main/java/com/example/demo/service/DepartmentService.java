package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Department;

public interface DepartmentService {
	
	Department saveDepartment(Department dep);

	List<Department> fetchAllDepartment();

	Department getDepartmentById(Long id);

	String deleteDepartment(Long id);

	List<Department> getDepartmentByName(String name);
	
	List<Department> getDepartmentByHead(String name);
	
	List<Department> getDepartmentisActive();
	
	List<Department> getByIsActive(Boolean isActive);
	
	void deletbyId(Long departmentId);

}