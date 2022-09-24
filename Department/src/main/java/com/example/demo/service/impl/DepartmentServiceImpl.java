package com.example.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
    DepartmentRepository repository;
	
	
	//RestTemplate restTemplate = new RestTemplate(); /// samjha baba
	
	@Autowired
	RestTemplate template;
	
	@Override
	public Department saveDepartment(Department dep) {
		return repository.save(dep);
	}
	
	@Override
	public List<Department> fetchAllDepartment() {
		return repository.findAll();
	}
    
	@Override
	public Department getDepartmentById(Long id) {
		Optional<Department> dept =  repository.findById(id);
		
		if(dept.isPresent()) {
			
			template.getForObject("http://localhost:8080/user/department/"+id,Department[].class );
			return dept.get();
		} 
		
		throw new EntityNotFoundException("Department not found "+id);
		 
	}
	
	@Override
	public List<Department> getDepartmentByName(String name) { // get
		return repository.findByDepartmentName(name);
	}

	@Override
	public String deleteDepartment(Long id) {
		repository.deleteById(id);
		return "Department got deleted" + id;
	}

	@Override
	public List<Department> getDepartmentByHead(String name) {
		 return repository.findByDepartmentHead(name);
	}

	@Override
	public List<Department> getDepartmentisActive() {
		
		return repository.findByIsActive(true);
	}

	@Override
	public List<Department> getByIsActive(Boolean isActive) {
		return repository.findByIsActive(isActive);
	}

	@Override
	public void deletbyId(Long departmentId) {
		repository.deleteById(departmentId);
	}

	




}