package com.nextbook.requests;

import java.math.BigDecimal;

public class ProductRequestDTO {
	private String name;
	private BigDecimal price;
	private int quantity;
	
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
