package com.nextbook.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextbook.requests.UserRequestDTO;
import com.nextbook.responses.LoanAllLoansResponseDTO;
import com.nextbook.responses.SaleAllSalesResponseDTO;
import com.nextbook.responses.UserAllUsersResponseDTO;
import com.nextbook.responses.UserCreatedResponseDTO;
import com.nextbook.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<UserCreatedResponseDTO> registerUser(@RequestBody UserRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<UserAllUsersResponseDTO>> findAllUser() {
		return ResponseEntity.ok(userService.findAllUsers());
	}
	
	@GetMapping(value = "/{id}/sales")
	public ResponseEntity<List<SaleAllSalesResponseDTO>> findAllUserSales(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findAllUserSales(id));
	}
	
	@GetMapping(value = "/{id}/loans")
	public ResponseEntity<List<LoanAllLoansResponseDTO>> findAllUserLoans(@PathVariable Long id) {
		return ResponseEntity.ok(userService.findAllUserLoans(id));
	}
}
