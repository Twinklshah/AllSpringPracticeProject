package com.example.demo.service;

import java.util.List;

import com.example.demo.model.ClientRole;

public interface ClientRoleService {
	
	ClientRole addRole(ClientRole role);
	public List<ClientRole> getAllRoles(); 
	ClientRole updateRole(ClientRole role);

}
