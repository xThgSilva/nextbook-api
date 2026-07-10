package com.nextbook.responses;

import java.util.List;

import com.nextbook.entities.Sale;

public class SaleCreatedResponseDTO extends SaleAllSalesResponseDTO{
	private List<SaleItemResponseDTO> saleItems;
	
	public SaleCreatedResponseDTO(Sale sale) {
		super(sale);
		this.saleItems = sale.getSaleItems().stream().map(SaleItemResponseDTO::new).toList();
	}
	
	public List<SaleItemResponseDTO> getSaleItems() {
		return saleItems;
	}
}
