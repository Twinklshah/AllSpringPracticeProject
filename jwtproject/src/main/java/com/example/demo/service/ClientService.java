package com.example.demo.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.LoginDto;
import com.example.demo.model.Client;

public interface ClientService extends UserDetailsService {
	
	public ClientDTO saveClient(ClientDTO clientdto);
	public List<Client> getAllClient();
	public LoginDto login(LoginDto loginDto)throws Exception;
	

}
