package com.nextbook.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import com.nextbook.entities.Product;
import com.nextbook.repositories.ProductRepository;
import com.nextbook.requests.ProductRequestDTO;
import com.nextbook.responses.ProductAllProductsDTO;
import com.nextbook.responses.ProductFindDetailsResponseDTO;
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
	
	public ProductFindDetailsResponseDTO findProductById(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product with Id: " + id + " not found."));
	
		return new ProductFindDetailsResponseDTO(product);
	}
	
	public Page<ProductAllProductsDTO> findAllProducts(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Product> products = productRepository.findAll(pageable);
		
		return products.map(ProductAllProductsDTO::new);
	}
	
	public void deleteProduct(Long id) {
		Product product = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Product with Id: " + id + " not found."));
		
		productRepository.delete(product);
	}
}
