package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    
	@Autowired
    DepartmentRepository repository;
	
	public Department saveDepartment(Department dep) {
		return repository.save(dep);
	}
	
	public List<Department> fetchAllDepartment() {
		return repository.findAll();
	}
    
	public Optional<Department> getDepartmentById(Long id) {
		return repository.findById(id);
	}
	
	public Department getDepartmentByName(String name) { // get
		return repository.findByDepartmentName(name);
	}

	public String delDepartment(Long id) { // delete
		repository.deleteById(id);
		return "product deleted"  + id;

	}
	
//	public Department updateDepartment(Department department) throws Exception {
//		if(department.getId()!=null) {
//			return repository.save(department);
//			
//		}
//		throw new Exception("please enter id to update");
//	
//		
//		
//		
//	}
//	@Override
////	public Department saveDepartment() {
////		// TODO Auto-generated method stub
////		return null;
////	}

	@Override
	public Department getProductByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Department getProductByName(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}




	
}
