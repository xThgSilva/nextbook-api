package com.nextbook.responses;

import java.math.BigDecimal;

import com.nextbook.entities.Product;

public abstract class ProductBaseResponseDTO {
	private Long id;
	private String name;
	private BigDecimal price;
	private String description;
	private int quantity;
	private String imageUrl;
	
	public ProductBaseResponseDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.description = product.getDescription();
		this.quantity = product.getQuantity();
		this.imageUrl = product.getImageUrl();
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
	public String getDescription() {
		return description;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getImageUrl() {
		return imageUrl;
	}
}
