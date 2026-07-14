package com.nextbook.requests;

import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SaleRequestDTO {
	@NotNull(message = "User is required.")
    private Long userId;

    @NotNull(message = "Sale items are required.")
    @Size(min = 1, message = "Sale must have at least one item.")
    private List<@Valid SaleItemRequestDTO> saleItems;
	
	public Long getUserId() {
		return userId;
	}
	public List<SaleItemRequestDTO> getSaleItems() {
		return saleItems;
	}
}
