package com.github.julioevencio.apiordermanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.julioevencio.apiordermanagement.entities.Product;
import com.github.julioevencio.apiordermanagement.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> optional = productRepository.findById(id);
		
		return optional.get();
	}
	
}
