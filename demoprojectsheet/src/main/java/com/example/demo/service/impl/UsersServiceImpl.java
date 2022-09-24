package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Users;
import com.example.demo.repository.UsersRepository;
import com.example.demo.service.UsersService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersRepository usersRepository;

	@Override
	public Users saveUsers(Users user) {
		log.info("Users get Save");
		return usersRepository.save(user);
		
	}

	@Override
	public List<Users> getUsers() {
		log.info("Get All users");
		return usersRepository.findAll();
		
	}

	@Override
	public Users findUsersById(Long id) throws Exception {
		log.info("FindUserById method called");
		Optional<Users> userResponse=usersRepository.findById(id);
		if(userResponse.isPresent()) {
			return userResponse.get();
			
		}
		throw new Exception("id not found");
	}

	@Override
	public Users updateUsers(Users user) throws Exception {
		log.info("Update Users Method Called");
		if(user.getUsersId()!=null) {
			Optional<Users> userValue=usersRepository.findById(user.getUsersId());
			if(userValue.isPresent()) {
				
				if(user.getUsersName()!=null) {
					userValue.get().setUsersName(user.getUsersName());
				}
				
				if(user.getDepartmentId()!=null) {
					userValue.get().setDepartmentId(user.getDepartmentId());
				}
				
				if(user.getUsersAddress()!=null) {
					userValue.get().setUsersAddress(user.getUsersAddress());
				}
				
				if(user.getMobileNo()!=null) {
					userValue.get().setMobileNo(user.getMobileNo());
				}
				return usersRepository.save(user);
			}
		}
		throw new Exception("please Enter your id");
	
	}

	
	
	@Override
	public String deleteUsers(Long id) {
		log.info("Delete Users Method Called");
		 
		Optional<Users> findbyId=usersRepository.findById(id);
		if(findbyId.isPresent())
		{
			usersRepository.deleteById(id);
		}
		
		return "data got deleted" +id;
//		throw new Exception("id not found");

	}

	@Override
	public List<Users> findByDepartmentId(Integer id) throws Exception {
		log.info("Find By Department id Method call");
		List<Users> userResult=usersRepository.findByDepartmentId(id);
		if(userResult !=null) {
			return userResult;
		}
		throw new Exception("please Enter your id");
	}

	}

	 
	



