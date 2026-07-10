package com.nextbook.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nextbook.requests.UserRequestDTO;
import com.nextbook.responses.UserCreatedResponseDTO;
import com.nextbook.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<UserCreatedResponseDTO> registerUser(@RequestBody UserRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(dto));
	}
}
