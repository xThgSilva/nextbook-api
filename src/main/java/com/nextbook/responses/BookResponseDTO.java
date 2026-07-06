package com.nextbook.responses;

import java.math.BigDecimal;

import com.nextbook.entities.Availability;
import com.nextbook.entities.Book;
import com.nextbook.entities.Category;

public class BookResponseDTO {
	private Long id;
	private String name;
	private String author;
	private BigDecimal price;
	private String imageUrl;
	private Category category;
	private Availability availability;
	
	public BookResponseDTO(Book book) {
		this.id = book.getId();
		this.name = book.getProduct().getName();
		this.author = book.getAuthor();
		this.price = book.getProduct().getPrice();
		this.imageUrl = book.getProduct().getImageUrl();
		this.category = book.getCategory();
		this.availability = book.getAvailability();
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAuthor() {
		return author;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public Category getCategory() {
		return category;
	}
	public Availability getAvailability() {
		return availability;
	}
	public String getImageUrl() {
		return imageUrl;
	}
}
