package com.nextbook.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.nextbook.requests.LoanRequestDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_loans")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@Column(nullable = false)
	private LocalDateTime loanDate;
	
	@Column(nullable = false)
	private LocalDate expectedReturnDate;
	
	@Column(nullable = false)
	private LocalDate returnDate;
	
	@Enumerated(EnumType.STRING)
	private ReturnStatus returnStatus;
	
	public Loan() {  }
	
	public Loan(LoanRequestDTO dto) {
		this.expectedReturnDate = dto.getExpectedReturnDate();
		this.returnDate = dto.getReturnDate();
	}

	public Long getId() {
		return id;
	}
	public User getUser() {
		return user;
	}
	public Book getBook() {
		return book;
	}
	public LocalDateTime getLoanDate() {
		return loanDate;
	}
	public LocalDate getExpectedReturnDate() {
		return expectedReturnDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public ReturnStatus getReturnStatus() {
		return returnStatus;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public void setLoanDate(LocalDateTime loanDate) {
		this.loanDate = loanDate;
	}
	public void setReturnStatus(ReturnStatus returnStatus) {
		this.returnStatus = returnStatus;
	}
}
