package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Department;

public interface DepartmentService {
	
	public Department saveDepartment(Department department);

	public Page<Department> getAllDepartment(int page,int size );
	
	public UserDTO[] getDepartmentById(Long id) throws Exception;
	
	public Department updateDepartment(Department department)throws Exception;
	
	public String deleteDepartment(Long id);
	
}
