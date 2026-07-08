package com.nextbook.services;

import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.nextbook.entities.Book;
import com.nextbook.entities.Loan;
import com.nextbook.entities.ReturnStatus;
import com.nextbook.entities.User;
import com.nextbook.repositories.BookRepository;
import com.nextbook.repositories.LoanRepository;
import com.nextbook.repositories.UserRepository;
import com.nextbook.requests.LoanRequestDTO;
import com.nextbook.responses.LoanAllLoansResponseDTO;
import com.nextbook.responses.LoanResponseDTO;

@Service
public class LoanService {

	private final LoanRepository loanRepository;
	private final UserRepository userRepository;
	private final BookRepository bookRepository;
	
	public LoanService(LoanRepository loanRepository, UserRepository userRepository, BookRepository bookRepository) {
		this.loanRepository = loanRepository;
		this.userRepository = userRepository;
		this.bookRepository = bookRepository;
	}

	public LoanResponseDTO createLoan(LoanRequestDTO dto) {
		Loan loan = new Loan(dto);
		
		User userLoan = userRepository.findById(dto.getUserId())
				.orElseThrow(() -> new RuntimeException("User with Id: " + dto.getUserId() + "not found."));
		
		Book bookLoan = bookRepository.findById(dto.getBookId())
				.orElseThrow(() -> new RuntimeException("Book with Id: " + dto.getBookId() + " not found."));
		
		loan.setLoanDate(LocalDateTime.now());
		loan.setReturnStatus(ReturnStatus.IN_PROGRESS);
		loan.setUser(userLoan);
		loan.setBook(bookLoan);
		
		loanRepository.save(loan);
		
		return new LoanResponseDTO(loan);
	}
	
	public Page<LoanAllLoansResponseDTO> findAllLoans(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Loan> loans = loanRepository.findAll(pageable);
		
		return loans.map(LoanAllLoansResponseDTO::new);
	}
}
