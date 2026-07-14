package com.nextbook.requests;

import jakarta.validation.constraints.NotNull;

public class LoanRequestDTO {
	@NotNull(message = "User is required.")
    private Long userId;

    @NotNull(message = "Book is required.")
    private Long bookId;

	public Long getUserId() {
		return userId;
	}
	public Long getBookId() {
		return bookId;
	}
}
