package com.nextbook.requests;

import java.math.BigDecimal;

public class ProductRequestDTO extends ProductBaseRequestDTO {
	public ProductRequestDTO(String name, BigDecimal price, String description, int quantity, String imageUrl) {
		super(name, price, description, quantity, imageUrl);
	}
}
