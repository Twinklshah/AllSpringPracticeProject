package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.LoginDto;
import com.example.demo.model.Client;
import com.example.demo.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/save")
	public ClientDTO saveClient(@RequestBody  ClientDTO clientdto) {
		return clientService.saveClient(clientdto);
	}
	
	
	@PostMapping("/login")
	public LoginDto login(@RequestBody LoginDto loginDto) throws Exception {
		return clientService.login(loginDto);
	}
	
	@GetMapping("/getClient")
	public List<Client> getAllClient() {
		return clientService.getAllClient();
	}
	
	@GetMapping("/accessByManager")
	@PreAuthorize("hasRole('MANAGER')") // this method is only accessible by Manager
	public String accessByManager() {
		return "Manager role accessed";
	}
	
	@GetMapping("/accessByAdmin")
	@PreAuthorize("hasRole('ADMIN')") // this method is only accessible by admin
	public String accessByAdmin() {
		return "Admin role accessed";
	}
}
