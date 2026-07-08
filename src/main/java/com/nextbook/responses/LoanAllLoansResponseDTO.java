package com.nextbook.responses;

import java.time.LocalDate;

import com.nextbook.entities.Loan;
import com.nextbook.entities.ReturnStatus;

public class LoanAllLoansResponseDTO extends LoanResponseDTO {
	private ReturnStatus returnStatus;
	private LocalDate returnDate;

	public LoanAllLoansResponseDTO(Loan loan) {
		super(loan);
		this.returnStatus = loan.getReturnStatus();
		this.returnDate = loan.getReturnDate();
	}
	public ReturnStatus getReturnStatus() {
		return returnStatus;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
}
