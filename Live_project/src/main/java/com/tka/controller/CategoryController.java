package com.tka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Category;
import com.tka.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryService service;
	
	@GetMapping("/categories")
	public List<Category> getAllCategories(){
		
		return service.getAllCategories();
	}
	
	@GetMapping("/categories/{cId}")
	public Category getCatById(@PathVariable int cId) {
		
		return service.getCatById(cId);
	}
	
	@PostMapping("/categories")
	public String addCategory(@RequestBody Category category) {
				
		return service.addCategory(category);
	}
	
	@PutMapping("/categories")
	public String updateCategory(@RequestBody Category category) {
		
		return service.updateCategory(category);
	}
	
	@DeleteMapping("/categories/{cId}")
	public String deleteCategory(@PathVariable int cId) {
		
		return service.deleteCategory(cId);
	}
	
}
