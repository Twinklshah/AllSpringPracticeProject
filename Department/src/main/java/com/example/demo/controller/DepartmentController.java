package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    
	@Autowired
	DepartmentService deService;
	
	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department dep) {
	 return deService.saveDepartment(dep);
	 
	}
	
	@PutMapping("/update")
	public Department updateDepartment(@RequestBody Department dep) {
	 return deService.saveDepartment(dep); 
	}
	
	@GetMapping("/all-department")
	public List<Department> fetchAllDepartment(){
		return deService.fetchAllDepartment();
	}
	
	@GetMapping("/{id}")
	public Optional<Department> getDepartmentById(@PathVariable Long id) {
		return deService.getDepartmentById(id);
	}
	
	 @GetMapping("/productByName/{name}")
	 public Department findProductByName(@PathVariable  String name) {
		 return deService.getProductByName(name);
	 }
	
	 @DeleteMapping("/Delproduct/{id}")
	 public String deleteProduct(@PathVariable Long id) {
		return deService.delDepartment(id);
		
	 }
}
