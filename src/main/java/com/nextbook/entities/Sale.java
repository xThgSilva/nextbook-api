package com.nextbook.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.nextbook.responses.SaleItemResponseDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_sales")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(nullable = false)
	private LocalDateTime saleDate;
	
	@Column(nullable = false, precision = 5, scale = 2)
	private BigDecimal totalSale;
	
	@OneToMany(mappedBy = "sale", cascade = CascadeType.PERSIST)
	private List<SaleItemResponseDTO> saleItems;
	
	public Sale() {	}

	public Long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public LocalDateTime getSaleDate() {
		return saleDate;
	}
	public BigDecimal getTotalSale() {
		return totalSale;
	}
	public List<SaleItemResponseDTO> getSaleItems() {
		return saleItems;
	}
}
