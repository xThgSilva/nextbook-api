package com.nextbook.responses;

import com.nextbook.entities.Product;

public class ProductCreatedResponseDTO extends ProductBaseResponseDTO {
	public ProductCreatedResponseDTO(Product product) {
		super(product);
	}
}
