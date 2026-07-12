package com.nextbook.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nextbook.entities.Availability;
import com.nextbook.entities.Category;
import com.nextbook.entities.Product;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductAllProductsDTO extends ProductBaseResponseDTO{
	public Long bookId;
	private String author;
	private Category category;
	private Availability availability;
	
	public ProductAllProductsDTO(Product product) {
		super(product);
		if (product.getBook() != null) {
			this.bookId = product.getBook().getId();
	        this.author = product.getBook().getAuthor();
	        this.category = product.getBook().getCategory();
	        this.availability = product.getBook().getAvailability();
	    }
	}

	public String getAuthor() {
		return author;
	}
	public Category getCategory() {
		return category;
	}
	public Availability getAvailability() {
		return availability;
	}
}
