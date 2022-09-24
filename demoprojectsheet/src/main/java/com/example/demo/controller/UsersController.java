package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Users;
import com.example.demo.service.UsersService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	@PostMapping("/save")
	public Users saveUsers(@RequestBody  Users user) {
	 log.info("Save Users Method Called" +user);
	 return	usersService.saveUsers(user);
	}
     
	@GetMapping("/allUser")
	public List<Users> getAllUsers() {
		log.info("Get all method called");
		return usersService.getUsers();
	}
	
	@GetMapping("/getByDepartmentId/{departmentId}")
	public List<Users> getByDepartmentId(@PathVariable Integer departmentId) throws Exception {
		log.info("Get By DepartmentId Called in controller");
		return usersService.findByDepartmentId(departmentId);
	}
	
	@GetMapping("/{id}")
	public Users findUsersById(@PathVariable Long id) throws Exception {
		log.info("Find User By Id Method Called");
		return usersService.findUsersById(id);
	}
	
	@PutMapping("/update")
	public Users updateUsers(@RequestBody Users user) throws Exception{
		log.info("Users get updated");
		return usersService.saveUsers(user);
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUsers(@PathVariable Long id) throws Exception
	{
		log.info("user deleted");
		return usersService.deleteUsers(id);
	}
}
