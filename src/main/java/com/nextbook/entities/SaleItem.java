package com.nextbook.entities;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sale_items")
public class SaleItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "sale_id")
	private Sale sale;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal unitPrice;
	
	@Column(nullable = false)
	private int quantity;
	
	public SaleItem() {	}

	public Long getId() {
		return id;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
}
