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

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
    @Autowired
	CustomerService customerService;
    
    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){

    	return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<Customer>> getAllCustomer(){
    	return new ResponseEntity<List<Customer>>(customerService.getAllCustomer(),HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) throws Exception{
    	return new ResponseEntity<Customer>(customerService.getCustomerById(id),HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws Exception{
    	return new ResponseEntity<Customer>(customerService.updateCustomer(customer),HttpStatus.ACCEPTED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id)throws Exception{
    	return new ResponseEntity<Void>(customerService.deleteCustomerById(id),HttpStatus.ACCEPTED);
    }
}

