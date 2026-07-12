package com.nextbook.requests;

import java.math.BigDecimal;

public class ProductUpdateRequestDTO extends ProductBaseRequestDTO{
	private String author;
	
	public ProductUpdateRequestDTO(String name, BigDecimal price, String description, int quantity, String imageUrl,
			String author) {
		super(name, price, description, quantity, imageUrl);
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}
}
