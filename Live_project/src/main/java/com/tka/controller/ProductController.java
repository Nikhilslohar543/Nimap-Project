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

import com.tka.entity.Products;
import com.tka.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/products/{cId}")
	public List<Products> getAllProducts(@PathVariable int cId){
		
		return service.getAllProducts(cId);
	}
	
	@GetMapping("/products/id/{pId}")
	public Products getProductById(@PathVariable int pId) {
		
		return service.getProductById(pId);
	}
	
	@PostMapping("/products/{cId}")
	public String addProduct(@PathVariable int cId, @RequestBody Products product) {
		System.out.println(cId);
		return service.addProduct(cId,product);
	}
	
	@PutMapping("/products/{cId}")
	public String updateProduct(@PathVariable int cId, @RequestBody Products product) {
		
		return service.updateProduct(cId ,product);
	}
	
	@DeleteMapping("/products/{pId}")
	public String deleteProduct(@PathVariable int pId) {
		return service.deleteProduct(pId);
	}
	
}
