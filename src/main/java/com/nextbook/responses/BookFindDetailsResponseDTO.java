package com.nextbook.responses;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.nextbook.entities.Availability;
import com.nextbook.entities.Book;
import com.nextbook.entities.Category;

public class BookFindDetailsResponseDTO {
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
	
	public BookFindDetailsResponseDTO(Book book) {
		this.id = book.getId();
		this.name = book.getProduct().getName();
		this.price = book.getProduct().getPrice();
		this.quantity = book.getProduct().getQuantity();
		this.author = book.getAuthor();
		this.publicationDate = book.getPublicationDate();
		this.imageUrl = book.getProduct().getImageUrl();
		this.description = book.getDescription();
		this.category = book.getCategory();
		this.availability = book.getAvailability();
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
