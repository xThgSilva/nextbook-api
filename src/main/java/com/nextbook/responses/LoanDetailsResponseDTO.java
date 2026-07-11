package com.nextbook.responses;

import java.time.LocalDate;

import com.nextbook.entities.Loan;
import com.nextbook.entities.ReturnStatus;

public class LoanDetailsResponseDTO extends LoanBaseResponseDTO {
    private LocalDate expectedReturnDate;
    private LocalDate returnDate;
    private ReturnStatus returnStatus;
    private String bookAuthor;

    public LoanDetailsResponseDTO(Loan loan) {
        super(loan);
        this.expectedReturnDate = loan.getExpectedReturnDate();
        this.returnDate = loan.getReturnDate();
        this.returnStatus = loan.getReturnStatus();
        this.bookAuthor = loan.getBook().getAuthor();
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
	public String getBookAuthor() {
		return bookAuthor;
	}
}
