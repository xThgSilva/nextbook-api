package com.nextbook.responses;

import java.math.BigDecimal;

import com.nextbook.entities.Product;

public class ProductResponseDTO {
	private Long id;
	private String name;
	private BigDecimal price;
	private String description;
	private int quantity;
	private String imageUrl;
	
	public ProductResponseDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.quantity = product.getQuantity();
		this.imageUrl = product.getImageUrl();
		this.description = product.getDescription();
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getDescription() {
		return description;
	}
}
