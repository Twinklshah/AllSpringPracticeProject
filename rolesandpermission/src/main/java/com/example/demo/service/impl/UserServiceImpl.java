package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public  List<User> getAllUser() {
		return userRepository.findAll();
		}

	@Override
	public User updateUser(User user) throws Exception {
		if(user.getId()!=null) {
			Optional<User> userResponse=userRepository.findById(user.getId());
			if(userResponse.isPresent()) {
				User uservalue=userResponse.get();
				
				if(user.getFirstName()!=null) {
					uservalue.setFirstName(user.getFirstName());
				}
				
				if(user.getLastName()!=null) {
					uservalue.setLastName(user.getLastName());
				}
				
				if(user.getEmail()!=null) {
					uservalue.setEmail(user.getEmail());
				}
				if(user.getDob()!=null) {
					uservalue.setDob(user.getDob());
				}
				
				if(user.getPassword()!=null) {
					uservalue.setPassword(user.getPassword());
				}
				return userRepository.save(user);
			}
		}
		throw new Exception("id not found");
		
//		Optional<User> userResponse=userRepository.findById();
		
	}

	
	
	

	

}
