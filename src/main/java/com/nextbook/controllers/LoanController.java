package com.nextbook.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextbook.requests.LoanRequestDTO;
import com.nextbook.responses.LoanResponseDTO;
import com.nextbook.services.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanController {

	private final LoanService loanService;
	
	public LoanController(LoanService loanService) {
		this.loanService = loanService;
	}

	@PostMapping(value = "/create")
	public ResponseEntity<LoanResponseDTO> createLoan(@RequestBody LoanRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(loanService.createLoan(dto));
	}
}
