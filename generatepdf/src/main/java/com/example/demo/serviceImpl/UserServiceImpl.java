package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {

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
	public User getUserById(Long id) throws Exception {
		Optional<User> userValue=userRepository.findById(id);
		if(userValue.isPresent()) {
			return userValue.get();
		}
		throw new Exception("id not found");
	}


	@Override
	public User updateUser(User user) throws Exception {
		if(user.getUserId()!=null) {
			Optional<User> users=userRepository.findById(user.getUserId());
			if(users.isPresent()) {
				User userResponse=users.get();

				if(user.getUserName()!=null) {
					userResponse.setUserName(user.getUserName());
				}
				if(user.getUserCity()!=null) {
					userResponse.setUserCity(user.getUserCity());

				}
				if(user.getUserAdd()!=null) {
					userResponse.setUserAdd(user.getUserAdd());
				}
				if(user.getUserAge()!=null) {
					userResponse.setUserAge(user.getUserAge());

				}
			}
			return userRepository.save(user);
		}
		throw new Exception("id not found");
	}


	@Override
	public List<User> findByUserName(String name) {
		return userRepository.findByUserName(name);
		
	}


	

}