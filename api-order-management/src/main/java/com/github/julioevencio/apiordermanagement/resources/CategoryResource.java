package com.github.julioevencio.apiordermanagement.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.julioevencio.apiordermanagement.entities.Category;
import com.github.julioevencio.apiordermanagement.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/categories")
@Tag(name = "Categories", description = "Endpoints for categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(
			summary = "Return all categories",
			description = "Return all categories",
			tags = {"Categories"},
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Return all categories",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									array = @ArraySchema(schema = @Schema(implementation = Category.class))
							)
					)
			}
	)
	public ResponseEntity<List<Category>> findAll() {
		List<Category> categories = categoryService.findAll();
		
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(
			summary = "Return category by id",
			description = "Return category by id",
			tags = {"Categories"},
			responses = {
					@ApiResponse(
							responseCode = "200",
							description = "Return category by id",
							content = @Content(
									mediaType = MediaType.APPLICATION_JSON_VALUE,
									schema = @Schema(implementation = Category.class)
							)
					)
			}
	)
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category category = categoryService.findById(id);
		
		return ResponseEntity.ok().body(category);
	}
	
}
