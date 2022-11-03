package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;

@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper {

	
	public Customer toEntity(CustomerDTO dto);   //service to repsot
	
	public CustomerDTO toDto(Customer customer);  //// reposirir to sevu
	
	
}
