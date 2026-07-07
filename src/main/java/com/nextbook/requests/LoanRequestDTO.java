package com.nextbook.requests;

import java.time.LocalDate;

public class LoanRequestDTO {
	private Long userId;
	private Long bookId;
	private LocalDate expectedReturnDate;
	private LocalDate returnDate;
	
	public LocalDate getExpectedReturnDate() {
		return expectedReturnDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public Long getUserId() {
		return userId;
	}
	public Long getBookId() {
		return bookId;
	}
}
