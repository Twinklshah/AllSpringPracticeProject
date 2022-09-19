package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

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

	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomerById(Long id) throws Exception
	{
		Optional<Customer> customer=customerRepository.findById(id);
		if(customer.isPresent()) {
		  return customer.get();
		  
	}
		throw new Exception("id not found");
	}
	
	public Customer updateCustomer(Customer customer) throws Exception
	{
		if(customer.getCustomerId()!=null) {
		Optional<Customer> customers=customerRepository.findById(customer.getCustomerId());
		if(customers.isPresent()) {
			Customer customerDb=customers.get();
			
			if(customer.getCustomerName()!=null) {
				customerDb.setCustomerName(customer.getCustomerName());
			}
			if(customer.getCustomerOccupation()!=null) {
				customerDb.setCustomerOccupation(customer.getCustomerOccupation());
			}
			return customerRepository.save(customer);
		}
		
	}
		throw new Exception("id not found");
	}

	@Override
	public Void deleteCustomerById(Long id) throws Exception
	{
		Optional<Customer> customer=customerRepository.findById(id);
		if(customer.isPresent()) {
			customerRepository.deleteById(id);
		}
		throw new Exception("id not found");
	}
	
	

}
