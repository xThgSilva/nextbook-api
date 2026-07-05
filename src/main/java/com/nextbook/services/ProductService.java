package com.nextbook.services;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.nextbook.entities.Product;
import com.nextbook.repositories.ProductRepository;
import com.nextbook.requests.ProductRequestDTO;
import com.nextbook.responses.ProductResponseDTO;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ProductResponseDTO registerProduct(ProductRequestDTO dto) {
		if (dto.getPrice().compareTo(BigDecimal.ZERO) > 0 && dto.getQuantity() > 0 && dto.getName() != "") {
			Product product = new Product(dto);
			productRepository.save(product);	
			
			return new ProductResponseDTO(product);
		}
		else {
			throw new RuntimeException("Invalid data to create product.");
		}
	}
	
	public ProductResponseDTO findProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product with Id: " + id + " not found."));
	
		return new ProductResponseDTO(product);
	}
}
