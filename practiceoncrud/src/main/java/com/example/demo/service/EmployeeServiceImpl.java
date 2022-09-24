package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.custom.exception.BusinessException;
import com.example.demo.custom.exception.EmptyInputException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	  
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	
	public Employee saveEmployee(Employee emp) {
		if(emp.getEmpName().isEmpty() || emp.getEmpName().length()==0) {
			throw new EmptyInputException("601","inputs fields are empty");
		}
		Employee saveemployee =employeeRepository.save(emp);
		
	      return saveemployee;
	}
	
	public List<Employee> allEmployee(List<Employee> emp){
		return employeeRepository.saveAll(emp);
		
	}
	
	public List<Employee> getEmployee() { 
		return employeeRepository.findAll();
	}
	
	public Employee getEmpId(Long id) throws Exception // acche se samjha
	{ 
		Optional<Employee> emp=employeeRepository.findById(id);
		if(emp.isPresent()) {
			return emp.get(); ///wowwwwww yaaaaar mast se samjha.
			}
		throw new Exception("id not found");
		
	}
	
//	{
//		
//	   "empName" : "Ajay",
//	  
//	}
	
   public Employee updateEmployee(Employee emp) throws Exception {  // postman
		if(emp.getEmpId()!=null) {
		  Optional<Employee> employee= employeeRepository.findById(emp.getEmpId()); //database
		  if(employee.isPresent()) {
//			  Employee empDB = employee.get();  
			  
//			  empdDb {
//				  
//				  "empName" : "Ajay",
//				  "empDepartment" : "IT"
//				  
//				  
//			  }
			  
			  if(emp.getEmpName() != null) {         //ache se samjha yeah yeah
				  employee.get().setEmpName(emp.getEmpName());  //update 
			  }
			  if(emp.getEmpDepartment()!=null) {
				  employee.get().setEmpDepartment(emp.getEmpDepartment());
			  }
			 
			return employeeRepository.save(emp);
		  }
		  
		}
		
		throw new Exception("Plese enter id.");
		
	}
	
	
	public void deleteEmployeeById(Long id) throws Exception
	{
	Optional<Employee> emp	=employeeRepository.findById(id);
	if(emp.isPresent()) {
		employeeRepository.deleteById(id);
	}
	throw new Exception("id not found");
		
		
		
	}

//	@Override
//	public List<Employee> getEmployee(List<Employee> emp) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Employee saveEmployee() {
//		// TODO Auto-generated method stub
//		return null;
//	}


	
	

}
