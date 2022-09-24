package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee emp);
	List<Employee> allEmployee(List<Employee> emp);
	List<Employee> getEmployee();
	Employee getEmpId(Long id) throws Exception;
    Employee updateEmployee(Employee emp) throws Exception;
	void deleteEmployeeById(Long id) throws Exception;
	

}
