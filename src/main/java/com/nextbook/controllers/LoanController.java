package com.nextbook.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextbook.requests.LoanRequestDTO;
import com.nextbook.responses.LoanAllLoansResponseDTO;
import com.nextbook.responses.LoanCreatedResponseDTO;
import com.nextbook.responses.LoanDetailsResponseDTO;
import com.nextbook.services.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

	private final LoanService loanService;
	
	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	@PostMapping
	public ResponseEntity<LoanCreatedResponseDTO> createLoan(@RequestBody LoanRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(dto));
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<LoanDetailsResponseDTO> findLoanById(@PathVariable Long id) {
		return ResponseEntity.ok(loanService.findLoanById(id));
	}
	
	@GetMapping(value = "/{page}/{size}")
	public ResponseEntity<Page<LoanAllLoansResponseDTO>> findAllLoans(@PathVariable int page, @PathVariable int size) {
		return ResponseEntity.ok(loanService.findAllLoans(page, size));
	}
}
