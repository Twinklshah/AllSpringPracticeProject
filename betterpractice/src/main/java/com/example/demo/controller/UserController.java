package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.UserPdfConfig;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.lowagie.text.DocumentException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/save")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping("/getAll")
	public List<User> getAllUser(){
		return userService.getAllUser(); 
	}

	@Cacheable(value = "UserTable", key = "#id")
	@GetMapping(value="/{id}") //key will let us know ki which key cache should be stored in redis key should be always same as path varible
	 //used only for the getby like findByname,findByid except findall
    public User getUserById(@PathVariable Long id) throws Exception { 
		log.info("Getting user with ID {}.", id);
		return userService.getUserById(id); 
	}
    
	@CachePut(value = "users", key = "#user.userId") //cacheput is used for putmapping key should be alwys id for saving 
	@PutMapping("/update")
	public User updateUser(@RequestBody User user) throws Exception { 
		log.info("updating user with id");
		return userService.saveUser(user);  
	}
	
	@GetMapping("/export/pdf")
	public void exportToPdf(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        String currentDateTime = dateFormatter.format(new Date());
//         
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
//        response.setHeader(headerKey, headerValue);
		UserPdfConfig  config = new UserPdfConfig(userService.getAllUser());
		config.export(response);
	}
	
}

