package com.nextbook.requests;

import java.math.BigDecimal;
import java.time.LocalDate;
import com.nextbook.entities.Availability;
import com.nextbook.entities.Category;

public class BookRequestDTO extends ProductBaseRequestDTO{
	// Create a Book
	private String author;
	private LocalDate publicationDate;
	private Category category;
	private Availability availability;
	
	public BookRequestDTO(String name, BigDecimal price, String description, int quantity, String imageUrl,
			String author, LocalDate publicationDate, Category category,
			Availability availability) {
		super(name, price, description, quantity, imageUrl);
		this.author = author;
		this.publicationDate = publicationDate;
		this.category = category;
		this.availability = availability;
	}
	
	public String getAuthor() {
		return author;
	}
	public LocalDate getPublicationDate() {
		return publicationDate;
	}
	public Category getCategory() {
		return category;
	}
	public Availability getAvailability() {
		return availability;
	}
}
