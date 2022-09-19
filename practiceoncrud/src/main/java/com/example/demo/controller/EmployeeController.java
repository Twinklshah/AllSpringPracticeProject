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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
    
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		Employee employeesave= employeeService.saveEmployee(emp);
		return new ResponseEntity<Employee>(employeesave,HttpStatus.CREATED);
		
	}
	@PostMapping("/allEmpList")
	public  ResponseEntity <List<Employee>> allEmployee(@RequestBody List<Employee> emp){
		List<Employee> allemployee=employeeService.allEmployee(emp);
		return new ResponseEntity<List<Employee>>(allemployee,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllEmpList")
	public  ResponseEntity <List<Employee>> getEmployee(){   
		List<Employee> getallemp=employeeService.getEmployee();
           return new ResponseEntity<List<Employee>>(getallemp,HttpStatus.OK);
	}
	@GetMapping("/emp/{empId}")
	public ResponseEntity<Employee> getEmpById(@PathVariable Long empId) throws Exception{
		Employee getEmployeById=employeeService.getEmpId(empId);
		return new ResponseEntity<Employee>(getEmployeById,HttpStatus.OK);
	}
	
	@PutMapping("/updateEmp")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) throws Exception{
	Employee updateEmploye=employeeService.updateEmployee(emp);
	return new ResponseEntity<Employee>(updateEmploye,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteEmp/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) throws Exception{
		employeeService.deleteEmployeeById(id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	} 
	
	
	
	
	
}
