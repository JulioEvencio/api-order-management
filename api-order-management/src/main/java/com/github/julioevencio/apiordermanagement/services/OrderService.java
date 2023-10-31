package com.github.julioevencio.apiordermanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.julioevencio.apiordermanagement.entities.Order;
import com.github.julioevencio.apiordermanagement.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository OrderRepository;
	
	public List<Order> findAll() {
		return OrderRepository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> optional = OrderRepository.findById(id);
		
		return optional.get();
	}
	
}
