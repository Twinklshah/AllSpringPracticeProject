package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;

	@PostMapping("/save")
	public Department saveDepartment(@RequestBody Department dep) {
		return departmentService.saveDepartment(dep);

	}

	@PutMapping("/update")
	public Department updateDepartment(@RequestBody Department dep) {
		return departmentService.saveDepartment(dep);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		return departmentService.deleteDepartment(id);
	}

	@GetMapping("/all")
	public List<Department> getAllDepartment() {
		return departmentService.fetchAllDepartment();
	}

	@GetMapping("/get/{id}")
	public Department getDepartmentById(@PathVariable Long id) {
		return departmentService.getDepartmentById(id);
	}

	@GetMapping("/getbyName/{name}")
	public List<Department> findDepartmentByName(@PathVariable String name) {
		return departmentService.getDepartmentByName(name);
	}
	
	@GetMapping("/getbyHead/{head}")
	public List<Department> findDepartmentByHead(@PathVariable String head) {
		return departmentService.getDepartmentByHead(head);
	}

	@GetMapping("/getbyisActive")  // bydefault true
	public List<Department> findDepartmentByisActive() {
		return departmentService.getDepartmentisActive();
	}
	
	@GetMapping("/getByIsActive") // false yaa true
	public List<Department> getByIsActive(@RequestParam(name = "isActive", required = true) Boolean isActive) {
		return departmentService.getByIsActive(isActive);
	}
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Void> deleteByid(@PathVariable Long departmentId) {
//	    departmentService.deletbyId(departmentId);
//		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
//	}
}