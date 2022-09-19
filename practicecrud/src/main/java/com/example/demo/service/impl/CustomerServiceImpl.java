package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public List<Customer> saveAllCustomer(List<Customer> customer) {
		return customerRepository.saveAll(customer);
	}
	
	public List<Customer> getCustomer(){
		return customerRepository.findAll();
	}
	
	public String deleteCustomer(Long id) {
		 customerRepository.deleteById(id);
		 return "records deleted"+id;
		 
	}
	
	public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}
	

}

