package com.nextbook.requests;

import java.time.LocalDate;
import com.nextbook.entities.Availability;
import com.nextbook.entities.Category;

public class BookRequestDTO extends ProductRequestDTO{
	// Create a Book
	private String author;
	private LocalDate publicationDate;
	private String description;
	private Category category;
	private Availability availability;
	
	public String getAuthor() {
		return author;
	}
	public LocalDate getPublicationDate() {
		return publicationDate;
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
