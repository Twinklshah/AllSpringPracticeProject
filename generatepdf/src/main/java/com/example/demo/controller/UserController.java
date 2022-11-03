package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.config.UserPdfGenerate;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.lowagie.text.DocumentException;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/save")
	public User saveUser( @RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@Autowired
	@GetMapping("/getAll")
	public List<User> getUser(){
		return userService.getAllUser();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) throws Exception{
		return userService.getUserById(id);
	}
	
	@GetMapping("/getByName/name")
	public List<User> getUserByUserName(@PathVariable String name) {
		return userService.findByUserName(name);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/pdf/name")
	public void exportToPdf(HttpServletResponse response, @PathVariable String name) throws DocumentException,IOException{
		response.setContentType("application/pdf");
		UserPdfGenerate userpdf = new UserPdfGenerate(userService.findByUserName(name));
		userpdf.export(response);
	}

}
