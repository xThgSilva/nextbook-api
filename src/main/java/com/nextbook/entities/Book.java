package com.nextbook.entities;

import java.time.LocalDate;

import com.nextbook.requests.BookRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(length = 100, nullable = false)
	private String author;
	
	@Column(nullable = false)
	private LocalDate publicationDate;
	
	@Column(length = 50, nullable = false)
	private String coverUrl;
	
	@Column(length = 150, nullable = false)
	private String description;
	
	@Enumerated(EnumType.STRING)
	private Category category;
	
	@Enumerated(EnumType.STRING)
	private Availability availability;
	
	public Book() {	}
	
	public Book(BookRequestDTO dto) {
		this.author = dto.getAuthor();
		this.publicationDate = dto.getPublicationDate();
		this.coverUrl = dto.getCoverUrl();
		this.description = dto.getDescription();
		this.category = dto.getCategory();
		this.availability = dto.getAvailability();
	}
	
	public Long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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