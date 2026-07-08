package com.nextbook.responses;

import java.math.BigDecimal;

import com.nextbook.entities.SaleItem;

public class SaleItemResponseDTO {
	private Long id;
	private Long saleId;
	private String productName;
	private String imageUrl;
	private BigDecimal unitPrice;
	private int quantity;
	
	public SaleItemResponseDTO(SaleItem saleItem) {
		this.id = saleItem.getId();
		this.saleId = saleItem.getSale().getId();
		this.productName = saleItem.getProduct().getName();
		this.imageUrl = saleItem.getProduct().getImageUrl();
		this.unitPrice = saleItem.getProduct().getPrice();
		this.quantity = saleItem.getQuantity();
	}
	
	public Long getId() {
		return id;
	}
	public Long getSaleId() {
		return saleId;
	}
	public String getProductName() {
		return productName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
}
