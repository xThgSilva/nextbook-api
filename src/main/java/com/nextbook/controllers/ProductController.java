package com.nextbook.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nextbook.requests.ProductRequestDTO;
import com.nextbook.requests.ProductUpdateRequestDTO;
import com.nextbook.responses.ProductAllProductsDTO;
import com.nextbook.responses.ProductCreatedResponseDTO;
import com.nextbook.responses.ProductDetailsResponseDTO;
import com.nextbook.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping
	public ResponseEntity<ProductCreatedResponseDTO> registerProduct(@RequestBody ProductRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.registerProduct(dto));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductDetailsResponseDTO> findProductById(@PathVariable Long id) {
		return ResponseEntity.ok(productService.findProductById(id));
	}
	
	@GetMapping(value = "/{page}/{size}")
	public ResponseEntity<Page<ProductAllProductsDTO>> findAllProducts(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return ResponseEntity.ok(productService.findAllProducts(page, size));
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ProductDetailsResponseDTO> updateProductById(
			@PathVariable Long id, 
			@RequestBody ProductUpdateRequestDTO dto) {
		return ResponseEntity.ok(productService.updateProductById(id, dto));
	}
}
