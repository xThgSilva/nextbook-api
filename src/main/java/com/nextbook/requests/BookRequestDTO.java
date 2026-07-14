package com.nextbook.requests;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.nextbook.entities.Availability;
import com.nextbook.entities.Category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class BookRequestDTO extends ProductBaseRequestDTO{
	// Create a Book
	@NotBlank(message = "Author is required.")
	@Size(max = 100, message = "Author must be at most 100 characters.")
	private String author;
	
	@NotNull(message = "Publication Date is required.")
	@Past(message = "The publication date cannot be a future date.")
	private LocalDate publicationDate;
	
	@NotNull(message = "Category is required.")
	private Category category;
	
	@NotNull(message = "Availability is required.")
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
