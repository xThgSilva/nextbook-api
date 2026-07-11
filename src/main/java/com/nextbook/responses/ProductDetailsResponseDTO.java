package com.nextbook.responses;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nextbook.entities.Availability;
import com.nextbook.entities.Category;
import com.nextbook.entities.Product;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetailsResponseDTO {
	private Long id;
	private String name;
	private BigDecimal price;
	private int quantity;
	private String author;
	private LocalDate publicationDate;
	private String imageUrl;
	private String description;
	private Category category;
	private Availability availability;
	
	public ProductDetailsResponseDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.price = product.getPrice();
		this.quantity = product.getQuantity();
		this.description = product.getDescription();
		this.imageUrl = product.getImageUrl();
		
		if (product.getBook() != null) {
			this.author = product.getBook().getAuthor();
			this.publicationDate = product.getBook().getPublicationDate();
			this.category = product.getBook().getCategory();
			this.availability = product.getBook().getAvailability();
		}
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
	public String getAuthor() {
		return author;
	}
	public LocalDate getPublicationDate() {
		return publicationDate;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getDescription() {
		return description;
	}
	public Category getCategory() {
		return category;
	}
	public Availability getAvailability() {
		return availability;
	}
}
