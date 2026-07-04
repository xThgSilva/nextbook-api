package com.nextbook.responses;

import java.math.BigDecimal;

import com.nextbook.entities.Book;

public class BookResponse {
	private Long id;
	private String name;
	private String author;
	private BigDecimal price;
	
	public BookResponse(Book book) {
		this.id = book.getId();
		this.name = book.getProduct().getName();
		this.author = book.getAuthor();
		this.price = book.getProduct().getPrice();
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
}
