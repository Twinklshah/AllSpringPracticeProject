package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.LoginDto;
import com.example.demo.mapper.ClientMapper;
import com.example.demo.mapper.LoginMapper;
import com.example.demo.model.Client;
import com.example.demo.model.ClientRole;
import com.example.demo.repository.ClientRepository;
import com.example.demo.security.jwtTokenHelper;
import com.example.demo.service.ClientService;

@Service
@Transactional
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	LoginMapper loginMapper;
	
	@Autowired
	ClientMapper clientMapper;
	
	

	@Override
	public ClientDTO saveClient(ClientDTO clientdto) {
		Client clientvalue= clientMapper.toEntity(clientdto);
	    Client clientResponse=clientRepository.save(clientvalue); //this is for request
	   ClientDTO client = clientMapper.toDTO(clientResponse); //this is for response
	    return client;
	}

	
	@Override
	public LoginDto login(LoginDto loginDto) throws Exception {
		
		
		Optional<Client> cl = clientRepository.findByUsernameAndPassword(loginDto.getUsername(), loginDto.getPassword());
		if(cl.isPresent()) {
		    LoginDto dto = loginMapper.toDTO(cl.get());
		    dto.setToken(jwtTokenHelper.generateToken(loginDto.getUsername()));
			return dto;
		}
		//Assert.notNull(user, "Invalid Credential"); // exception throw
		throw new Exception("Invalid Credential");
	}

	
	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Client> user = clientRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
				user.get().getPassword(), getAuthorities(user.get().getRole()));
	}
	
	//grantedAutthority its a interface provided by spring security 
	private List<GrantedAuthority> getAuthorities(final List<ClientRole> roles ){
		return roles.stream().map(role ->  new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		List<Client> clientresponse = clientRepository.findByUsername(username);
//		if (clientresponse == null) {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(clientresponse.get(0).getClientName(),
//				clientresponse.get(0).getPassword(), new ArrayList<>());  
//		
//	}


	

	
	

}
