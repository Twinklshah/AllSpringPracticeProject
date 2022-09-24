package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Department;

public interface DepartmentService {
	
	public Department saveDepartment(Department department);

	public List<Department> getAllDepartment();
	
	public UserDTO[] getDepartmentById(Long id) throws Exception;
	
	public Department updateDepartment(Department department)throws Exception;
	
	public String deleteDepartment(Long id);
	
}
