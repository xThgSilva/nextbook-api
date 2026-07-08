package com.nextbook.requests;

import java.util.List;

public class SaleRequestDTO {
	private Long userId;
	private List<SaleItemRequestDTO> saleItems;
	
	public Long getUserId() {
		return userId;
	}
	public List<SaleItemRequestDTO> getSaleItems() {
		return saleItems;
	}
}
