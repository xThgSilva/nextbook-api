package com.nextbook.responses;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nextbook.entities.Availability;
import com.nextbook.entities.Category;
import com.nextbook.entities.Product;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetailsResponseDTO extends ProductBaseResponseDTO {
	private String author;
	private LocalDate publicationDate;
	private Category category;
	private Availability availability;
	
	public ProductDetailsResponseDTO(Product product) {
		super(product);
		if (product.getBook() != null) {
			this.author = product.getBook().getAuthor();
			this.publicationDate = product.getBook().getPublicationDate();
			this.category = product.getBook().getCategory();
			this.availability = product.getBook().getAvailability();
		}
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
