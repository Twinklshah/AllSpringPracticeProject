package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	CustomerMapper customerMapper;
	

	
	//using mapper not manually
	public CustomerDTO saveCustomer(CustomerDTO customerdto) {
		Customer customer = customerMapper.toEntity(customerdto);  ///
		Customer customer1 = customerRepository.save(customer);
		CustomerDTO dto = customerMapper.toDto(customer1);
	
//	return customerMapper.toDto(customerRepository.save(customerMapper.toEntity(customerdto)));
		return dto;
		
	}
	
	public List<Customer> getCustomer() {
		return customerRepository.findAll();
		
	}
}
