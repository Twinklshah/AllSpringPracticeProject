package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
  @Autowired
  UserRepository userRepository;

@Override
public User saveUser(User user) {
	return userRepository.save(user);
	
	
}

@Override
public List<User> getAllUser() {
	return userRepository.findAll();
}



@Override
public User getUserById(Long id) throws Exception{
	Optional<User> user=userRepository.findById(id);
	if(user.isPresent()) {
		return user.get();
	}
	throw new Exception("id not found");
}

@Override
public User updateUser(User user) throws Exception {
	if(user.getUserId()!=null) {
		Optional<User> uservalue= userRepository.findById(user.getUserId());
		if(uservalue.isPresent()) {
		User	userResponse=uservalue.get();
			
			if(user.getUserName()!=null) {
				userResponse.setUserName(user.getUserName());
			}
			
			if(user.getUserAddress()!=null) {
				userResponse.setUserAddress(user.getUserAddress());
			}
			
			if(user.getUserAge()!=null) {
				userResponse.setUserAge(user.getUserAge());
			}

			}
		return userRepository.save(user);
	}
	  throw new Exception("id not found");
	  
	
}
 

 


	

}
