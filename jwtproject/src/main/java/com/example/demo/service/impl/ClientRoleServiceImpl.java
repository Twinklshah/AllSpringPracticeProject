package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.ClientRole;
import com.example.demo.repository.ClientRoleRepository;
import com.example.demo.service.ClientRoleService;

@Service
@Transactional
public class ClientRoleServiceImpl implements ClientRoleService {
	
	@Autowired
	ClientRoleRepository roleRepository;

	@Override
	public ClientRole addRole(ClientRole role) {
		return roleRepository.save(role);
	}

	@Override
	public List<ClientRole> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public ClientRole updateRole(ClientRole role) {
		// TODO Auto-generated method stub
		return null;
	}
}

	