package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.service.DepartmentService;
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
   
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public Department saveDepartment(Department department) {
	    return departmentRepository.save(department);
	}

	@Override
	public Page<Department> getAllDepartment(int page,int size) {
		
		PageRequest pageable =PageRequest.of(page,size);  
		return departmentRepository.findAll(pageable);
	}

	@Override
	public UserDTO[] getDepartmentById(Long id) throws Exception{
		Optional<Department> departmentResponse=departmentRepository.findById(id);
		if(departmentResponse.isPresent()) {
			UserDTO[] dto =  restTemplate.getForObject("http://localhost:8080/users/getByDepartmentId/"+id, UserDTO[].class);
		    return dto;
		}
	   throw new Exception("id not found");
	}

	@Override
	public Department updateDepartment(Department department) throws Exception {
	   if (department.getDepartmentId()!=null) {
		   Optional<Department> departmentValue=departmentRepository.findById(department.getDepartmentId());
		   if(departmentValue.isPresent()) {
			   
			   if (department.getDepartmentName()!=null) {
				   departmentValue.get().setDepartmentName(department.getDepartmentName());
			   }
			   if (department.getDepartmentHead()!=null) {
				   departmentValue.get().setDepartmentHead(department.getDepartmentHead());
			   }
			   
			   if (department.getDepartmentContact()!=null) {
				   departmentValue.get().setDepartmentContact(department.getDepartmentContact());
			   }
			   return departmentRepository.save(department);
		   }
	   }
	   throw new Exception("id not found");
	}

	@Override
	public String deleteDepartment(Long id) {
		Optional<Department> departmentResult=departmentRepository.findById(id);
		if(departmentResult.isPresent()) {
			departmentRepository.deleteById(id);
		}
		return "id got deleted" + id;
	}
	
	
	
	
	

}
