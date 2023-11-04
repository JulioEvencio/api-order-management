package com.github.julioevencio.apiordermanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.github.julioevencio.apiordermanagement.entities.User;
import com.github.julioevencio.apiordermanagement.repositories.UserRepository;
import com.github.julioevencio.apiordermanagement.services.exceptions.DatabaseException;
import com.github.julioevencio.apiordermanagement.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		try {
	        if (userRepository.existsById(id)) {
	        	userRepository.deleteById(id);			
	        } else {				
	            throw new ResourceNotFoundException("User not found");			
	        }		
	    } catch (DataIntegrityViolationException e) {			
	        throw new DatabaseException(e.getMessage());		
	    }
	}
	
	public User update(Long id, User user) {
		try {
			User userEntity = userRepository.getReferenceById(id);
			
			userEntity.setName(user.getName());
			userEntity.setEmail(user.getEmail());
			userEntity.setPhone(user.getPhone());
			
			return userRepository.save(userEntity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("User not found");
		}
	}
	
}
