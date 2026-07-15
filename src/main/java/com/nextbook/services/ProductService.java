package com.nextbook.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nextbook.entities.Product;
import com.nextbook.exceptions.NotFoundException;
import com.nextbook.repositories.ProductRepository;
import com.nextbook.requests.ProductRequestDTO;
import com.nextbook.requests.ProductUpdateRequestDTO;
import com.nextbook.responses.ProductAllProductsDTO;
import com.nextbook.responses.ProductCreatedResponseDTO;
import com.nextbook.responses.ProductDetailsResponseDTO;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ProductCreatedResponseDTO registerProduct(ProductRequestDTO dto) {
			Product product = new Product(dto);
			productRepository.save(product);	
			
			return new ProductCreatedResponseDTO(product);
	}
	
	public ProductDetailsResponseDTO findProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Product with Id " + id + " not found."));
	
		return new ProductDetailsResponseDTO(product);
	}
	
	public Page<ProductAllProductsDTO> findAllProducts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> products = productRepository.findAll(pageable);
		
		return products.map(ProductAllProductsDTO::new);
	}
	
	public ProductDetailsResponseDTO updateProductById(Long id, ProductUpdateRequestDTO dto) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Product with Id " + id + " not found."));
		
		product.setName(dto.getName());
		product.setQuantity(dto.getQuantity());
		product.setPrice(dto.getPrice());
		product.setDescription(dto.getDescription());
		
		if (product.getBook() != null) {
	        product.getBook().setAuthor(dto.getAuthor());
	    }
		
		productRepository.save(product);
		return new ProductDetailsResponseDTO(product);
	}
	
	public void deleteProduct(Long id) {
		productRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Product with Id " + id + " not found."));
		
		productRepository.deleteById(id);
	}
}
