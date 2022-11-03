package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {

	public User saveUser(User user);

	List<User> getAllUser();

	User getUserById(Long id) throws Exception;

	User updateUser(User user)throws Exception; 
	
//	User getUserByUserName(String userName);

	List<User> findByUserName(String name);



}  
