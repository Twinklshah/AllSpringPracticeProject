package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.LoginDto;
import com.example.demo.model.Client;

@Mapper(componentModel = "spring")
public interface LoginMapper {

	public LoginDto toDTO(Client client); 
	
	
}
