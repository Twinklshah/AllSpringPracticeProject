package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {

 Customer saveCustomer(Customer customer);
 List<Customer> getAllCustomer();
 Customer getCustomerById(Long id) throws Exception;
 Customer updateCustomer(Customer customer) throws Exception;
 Void deleteCustomerById(Long id) throws Exception;
}
