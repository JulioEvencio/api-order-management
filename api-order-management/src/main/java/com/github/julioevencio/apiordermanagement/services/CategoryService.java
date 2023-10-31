package com.github.julioevencio.apiordermanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.julioevencio.apiordermanagement.entities.Category;
import com.github.julioevencio.apiordermanagement.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		
		return optional.get();
	}
	
}
