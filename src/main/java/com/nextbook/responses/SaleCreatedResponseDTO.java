package com.nextbook.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.nextbook.entities.Sale;

public class SaleCreatedResponseDTO {
	private Long id;
	private String username;
	private LocalDateTime saleDate;
	private BigDecimal totalSale;
	private List<SaleItemResponseDTO> saleItems;
	
	public SaleCreatedResponseDTO(Sale sale) {
		this.id = sale.getId();
		this.username = sale.getUser().getName();
		this.saleDate = sale.getSaleDate();
		this.totalSale = sale.getTotalSale();
		this.saleItems = sale.getSaleItems().stream().map(SaleItemResponseDTO::new).toList();
	}
	
	public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public LocalDateTime getSaleDate() {
		return saleDate;
	}
	public List<SaleItemResponseDTO> getSaleItems() {
		return saleItems;
	}
	public BigDecimal getTotalSale() {
		return totalSale;
	}
}
