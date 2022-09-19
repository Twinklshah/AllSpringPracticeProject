package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
	CustomerService customerService;
    
    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(Customer customer){

    	return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
    }
    
    public ResponseEntity<List<Customer>> getAllCustomer(){
    	return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(),HttpStatus.OK);
    }
}

