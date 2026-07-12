package com.nextbook.responses;

import com.nextbook.entities.Availability;
import com.nextbook.entities.Book;
import com.nextbook.entities.Category;

public class BookResponseDTO extends ProductBaseResponseDTO {
	private Long bookId;
	private Category category;
	private Availability availability;
	
	public BookResponseDTO(Book book) {
		super(book.getProduct());
		this.bookId = book.getId();
		this.category = book.getCategory();
		this.availability = book.getAvailability();
	}
	
	public Long getBookId() {
		return bookId;
	}
	public Category getCategory() {
		return category;
	}
	public Availability getAvailability() {
		return availability;
	}
}
