package com.nextbook.responses;

import java.time.LocalDateTime;

import com.nextbook.entities.Loan;

public abstract class LoanBaseResponseDTO {
    private Long id;
    private String userName;
    private String bookName;
    private LocalDateTime loanDate;

    public LoanBaseResponseDTO(Loan loan) {
        this.id = loan.getId();
        this.userName = loan.getUser().getName();
        this.bookName = loan.getBook().getProduct().getName();
        this.loanDate = loan.getLoanDate();
    }

	public Long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getBookName() {
		return bookName;
	}
	public LocalDateTime getLoanDate() {
		return loanDate;
	}
}
    
