package com.github.julioevencio.apiordermanagement.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.julioevencio.apiordermanagement.entities.Order;
import com.github.julioevencio.apiordermanagement.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/orders")
@Tag(name = "Order", description = "Endpoints for orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(
			summary = "Return all orders",
			description = "Return all orders",
			tags = {"Orders"},
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Return all orders",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									array = @ArraySchema(schema = @Schema(implementation = Order.class))
							)
					)
			}
	)
	public ResponseEntity<List<Order>> findAll() {
		List<Order> orders = orderService.findAll();
		
		return ResponseEntity.ok().body(orders);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(
			summary = "Return order by id",
			description = "Return order by id",
			tags = {"Orders"},
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Return order by id",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = Order.class)
							)
					)
			}
	)
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order order = orderService.findById(id);
		
		return ResponseEntity.ok().body(order);
	}
	
}
