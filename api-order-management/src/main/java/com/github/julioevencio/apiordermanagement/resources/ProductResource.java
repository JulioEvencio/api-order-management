package com.github.julioevencio.apiordermanagement.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.julioevencio.apiordermanagement.entities.Product;
import com.github.julioevencio.apiordermanagement.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "Products", description = "Endpoints for products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(
			summary = "Return all products",
			description = "Return all products",
			tags = {"Products"},
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Return all products",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									array = @ArraySchema(schema = @Schema(implementation = Product.class))
							)
					)
			}
	)
	public ResponseEntity<List<Product>> findAll() {
		List<Product> products = productService.findAll();
		
		return ResponseEntity.ok().body(products);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(
			summary = "Return product by id",
			description = "Return product by id",
			tags = {"Products"},
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Return product by id",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = Product.class)
							)
					)
			}
	)
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product product = productService.findById(id);
		
		return ResponseEntity.ok().body(product);
	}
	
}
