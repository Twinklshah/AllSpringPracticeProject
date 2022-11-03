package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	 
	@PostMapping("/save")
	User saveUser(@RequestBody User user) {
		return userService.addUser(user);
		
	}
	@GetMapping("/getAll")
	public List<User> getAllUser(){
		return userService.getAllUser();
	}

	
	
}
