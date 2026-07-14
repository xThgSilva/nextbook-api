package com.nextbook.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class SaleItemRequestDTO {
	@NotNull(message = "Product is required.")
    private Long productId;

    @NotNull(message = "Quantity is required.")
    @Min(value = 1, message = "Quantity must be at least 1.")
    private int quantity;
	
	public Long getProductId() {
		return productId;
	}
	public int getQuantity() {
		return quantity;
	}
}
