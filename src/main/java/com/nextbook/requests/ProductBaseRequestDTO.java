package com.nextbook.requests;

import java.math.BigDecimal;

public abstract class ProductBaseRequestDTO {
	private String name;
	private BigDecimal price;
	private String description;
	private int quantity;
	private String imageUrl;
	
	public ProductBaseRequestDTO(String name, BigDecimal price, String description, int quantity, String imageUrl) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
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
