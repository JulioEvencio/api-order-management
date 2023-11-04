package com.github.julioevencio.apiordermanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.julioevencio.apiordermanagement.entities.User;
import com.github.julioevencio.apiordermanagement.repositories.UserRepository;
import com.github.julioevencio.apiordermanagement.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> optional = userRepository.findById(id);
		
		return optional.orElseThrow(() -> new ResourceNotFoundException("User not found"));
	}
	
	public User insert(User user) {
		return userRepository.save(user);
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}
	
	public User update(Long id, User user) {
		User userEntity = userRepository.getReferenceById(id);
		
		userEntity.setName(user.getName());
		userEntity.setEmail(user.getEmail());
		userEntity.setPhone(user.getPhone());
		
		return userRepository.save(userEntity);
	}
	
}
