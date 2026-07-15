package com.nextbook.services;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nextbook.entities.Book;
import com.nextbook.entities.Loan;
import com.nextbook.entities.ReturnStatus;
import com.nextbook.entities.User;
import com.nextbook.exceptions.InvalidStatusBookException;
import com.nextbook.exceptions.NotFoundException;
import com.nextbook.repositories.BookRepository;
import com.nextbook.repositories.LoanRepository;
import com.nextbook.repositories.UserRepository;
import com.nextbook.requests.LoanRequestDTO;
import com.nextbook.responses.LoanAllLoansResponseDTO;
import com.nextbook.responses.LoanCreatedResponseDTO;
import com.nextbook.responses.LoanDetailsResponseDTO;

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

	public LoanCreatedResponseDTO createLoan(LoanRequestDTO dto) {
		Loan loan = new Loan();
		
		User userLoan = userRepository.findById(dto.getUserId())
				.orElseThrow(() -> new NotFoundException("User with Id " + dto.getUserId() + " not found."));
		
		Book bookLoan = bookRepository.findById(dto.getBookId())
				.orElseThrow(() -> new NotFoundException("Book with Id " + dto.getBookId() + " not found."));
		
		if (bookLoan.getProduct().getQuantity() < 1) {
			throw new RuntimeException("Book unvailable.");
		}
		
		loan.setLoanDate(LocalDateTime.now());
		loan.setExpectedReturnDate(LocalDate.now().plusDays(14));
		loan.setReturnStatus(ReturnStatus.IN_PROGRESS);
		loan.setUser(userLoan);
		loan.setBook(bookLoan);
		loan.getBook().getProduct().setQuantity(
				loan.getBook().getProduct().getQuantity() - 1
				);
		
		loanRepository.save(loan);
		
		return new LoanCreatedResponseDTO(loan);
	}
	
	public LoanDetailsResponseDTO findLoanById(Long id) {
		Loan loan = loanRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Loan with Id " + id + " not found."));
		
		return new LoanDetailsResponseDTO(loan);
	}
	
	public Page<LoanAllLoansResponseDTO> findAllLoans(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Loan> loans = loanRepository.findAll(pageable);
		
		return loans.map(LoanAllLoansResponseDTO::new);
	}
	
	public LoanDetailsResponseDTO requestBookReturn(Long id) {
		Loan loan = loanRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Loan with Id " + id + " not found."));
		
		if (loan.getReturnStatus() != ReturnStatus.IN_PROGRESS) {
			throw new InvalidStatusBookException("This loan is not in progress.");
		}
		
		loan.setReturnStatus(ReturnStatus.RETURN_REQUESTED);
		loanRepository.save(loan);
		
		return new LoanDetailsResponseDTO(loan);
	}
	
	public LoanDetailsResponseDTO updateLoanStatus(Long id) {
		Loan loan = loanRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Loan with Id " + id + " not found."));
		
		if(loan.getReturnStatus() != ReturnStatus.RETURN_REQUESTED) {
			throw new InvalidStatusBookException("This loan has no pending return request.");
		}
		
		loan.setReturnDate(LocalDate.now());
		loan.setReturnStatus(ReturnStatus.RETURNED);
		loan.getBook().getProduct()
		.setQuantity(
				loan.getBook().getProduct().getQuantity() + 1
				);
		
		loanRepository.save(loan);
		
		return new LoanDetailsResponseDTO(loan);
	}
}
