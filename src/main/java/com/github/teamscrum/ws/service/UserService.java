package com.github.teamscrum.ws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.teamscrum.exception.ResourceNotFoundException;
import com.github.teamscrum.ws.model.User;
import com.github.teamscrum.ws.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public void save(User user) {
		if(user.isNew())
			user.setActive(true);
		
		repository.save(user);
	}
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findOne(Long id) {
		User user = repository.findOne(id);
		if(user == null)
			throw new ResourceNotFoundException("User not found!");
		
		return user; 
	}
	
}