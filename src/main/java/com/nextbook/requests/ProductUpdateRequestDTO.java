package com.nextbook.requests;

import java.math.BigDecimal;

public class ProductUpdateRequestDTO {
	private String name;
	private BigDecimal price;
	private int quantity;
	private String author;
	private String description;
	
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getAuthor() {
		return author;
	}
	public String getDescription() {
		return description;
	}
}
