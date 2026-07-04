package com.nextbook.requests;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.nextbook.entities.Availability;
import com.nextbook.entities.Category;

public class BookRequestDTO {
	// Create a Product first
	private String name;
	private BigDecimal price;
	private int quantity;
	
	// Create a Book
	private String author;
	private LocalDate publicationDate;
	private String coverUrl;
	private String description;
	private Category category;
	private Availability availability;
	
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
	public String getCoverUrl() {
		return coverUrl;
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
