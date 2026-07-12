package com.nextbook.entities;

import java.time.LocalDate;

import com.nextbook.requests.BookRequestDTO;

import jakarta.persistence.CascadeType;
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
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Column(length = 100, nullable = false)
	private String author;
	
	@Column(nullable = false)
	private LocalDate publicationDate;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Category category;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Availability availability;
	
	public Book() {	}
	
	public Book(BookRequestDTO dto) {
		this.author = dto.getAuthor();
		this.publicationDate = dto.getPublicationDate();
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
	public Category getCategory() {
		return category;
	}
	public Availability getAvailability() {
		return availability;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}