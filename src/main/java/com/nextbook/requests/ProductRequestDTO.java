package com.nextbook.requests;

import java.math.BigDecimal;

public class ProductRequestDTO {
	private String name;
	private BigDecimal price;
	private String description;
	private int quantity;
	
	private String imageUrl;
	
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
