package com.nextbook.responses;

import com.nextbook.entities.Loan;
import com.nextbook.entities.ReturnStatus;

public class LoanAllLoansResponseDTO extends LoanBaseResponseDTO{
	private ReturnStatus returnStatus;

    public LoanAllLoansResponseDTO(Loan loan) {
        super(loan);
        this.returnStatus = loan.getReturnStatus();
    }

	public ReturnStatus getReturnStatus() {
		return returnStatus;
	}
}
