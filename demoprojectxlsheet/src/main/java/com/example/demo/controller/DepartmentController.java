package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/allDepartment")
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartment();
	}
    
	@GetMapping("/{id}")
	public UserDTO[] getDepartmentById(@PathVariable Long id) throws Exception {
		return departmentService.getDepartmentById(id);
		
	}
	@PutMapping("/update")
	public Department updateDepartment(@RequestBody  Department department) throws Exception {
		return departmentService.updateDepartment(department);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		return departmentService.deleteDepartment(id);
	}
	
}
