package com.nextbook.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextbook.requests.ProductRequestDTO;
import com.nextbook.responses.ProductResponseDTO;
import com.nextbook.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<ProductResponseDTO> registerProduct(@RequestBody ProductRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.registerProduct(dto));
	}
}
