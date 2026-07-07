package com.nextbook.responses;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.nextbook.entities.Loan;

public class LoanResponseDTO {
	private Long id;
	private String name;
	private String bookName;
	private LocalDateTime loanDate;
	private LocalDate expectedReturnDate;
	
	public LoanResponseDTO(Loan loan) {
		this.id = loan.getId();
		this.name = loan.getUser().getName();
		this.bookName = loan.getBook().getProduct().getName();
		this.loanDate = loan.getLoanDate();
		this.expectedReturnDate = loan.getExpectedReturnDate();
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getBookName() {
		return bookName;
	}
	public LocalDateTime getLoanDate() {
		return loanDate;
	}
	public LocalDate getExpectedReturnDate() {
		return expectedReturnDate;
	}
}
