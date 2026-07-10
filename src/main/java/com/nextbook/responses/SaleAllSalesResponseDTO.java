package com.nextbook.responses;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.nextbook.entities.Sale;

public class SaleAllSalesResponseDTO {
	private Long id;
	private String costumerName;
	private LocalDateTime saleDate;
	private BigDecimal totalSale;
	
	public SaleAllSalesResponseDTO(Sale sale) {
		this.id = sale.getId();
		this.costumerName = sale.getUser().getName();
		this.saleDate = sale.getSaleDate();
		this.totalSale = sale.getTotalSale();
	}
	
	public Long getId() {
		return id;
	}
	public String getCostumerName() {
		return costumerName;
	}
	public LocalDateTime getSaleDate() {
		return saleDate;
	}
	public BigDecimal getTotalSale() {
		return totalSale;
	}
}
