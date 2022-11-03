package com.example.demo.mapper;

import org.mapstruct.Mapper;

import com.example.demo.dto.ClientDTO;
import com.example.demo.model.Client;


@Mapper(componentModel = "spring") //
public interface ClientMapper {
	
	public Client toEntity(ClientDTO clientdto); 
	public ClientDTO toDTO(Client client); 
	
	

}
