package com.nextbook.responses;

import java.math.BigDecimal;

import com.nextbook.entities.Product;

public class ProductResponseDTO {
	private Long id;
	private String name;
	private BigDecimal price;
	private int quantity;
	
	public ProductResponseDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.quantity = product.getQuantity();
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
}
