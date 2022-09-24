package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Users;

public interface UsersService {
	
	public Users saveUsers(Users user);
	public List<Users> getUsers();
	public Users findUsersById(Long id) throws Exception;
	public Users updateUsers(Users user)throws Exception ;
	public String deleteUsers(Long id) throws Exception;
	public List<Users> findByDepartmentId(Integer id) throws Exception;
	
	
	
	
	

}
