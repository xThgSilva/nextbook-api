package com.nextbook.responses;

import java.time.LocalDate;
import com.nextbook.entities.Loan;

public class LoanCreatedResponseDTO extends LoanBaseResponseDTO{
	private LocalDate expectedReturnDate;

    public LoanCreatedResponseDTO(Loan loan) {
        super(loan);
        this.expectedReturnDate = loan.getExpectedReturnDate();
    }
    
	public LocalDate getExpectedReturnDate() {
		return expectedReturnDate;
	}
}