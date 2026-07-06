package com.nextbook.entities;

import java.math.BigDecimal;
import com.nextbook.requests.BookRequestDTO;
import com.nextbook.requests.ProductRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@Column(precision = 5, scale = 2, nullable = false)
	private BigDecimal price;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(length = 50, nullable = false)
	private String imageUrl;
	
	@OneToOne(mappedBy = "product")
	private Book book;
	
	public Product() { }
	
	// To create a Book
	public Product(BookRequestDTO dto) {
		this.name = dto.getName();
		this.price = dto.getPrice();
		this.quantity = dto.getQuantity();
		this.imageUrl = dto.getImageUrl();
	}
	
	// To create just Product
	public Product(ProductRequestDTO dto) {
		this.name = dto.getName();
		this.price = dto.getPrice();
		this.quantity = dto.getQuantity();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public Book getBook() {
		return book;
	}
}
