package com.nextbook.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nextbook.entities.User;
import com.nextbook.repositories.UserRepository;
import com.nextbook.requests.UserRequestDTO;
import com.nextbook.responses.UserResponseDTO;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	// TODO - Errors pattern
	public UserResponseDTO register(UserRequestDTO dto) {
		Optional<User> emailExists = userRepository.findByEmail(dto.getEmail());
		
		if (emailExists.isPresent())
			throw new RuntimeException("E-mail already registered.");
		
		if (!dto.getPassword().equals(dto.getConfirmPassword()))
			throw new RuntimeException("The password confirmation must match the password.");

			User user = new User(dto);
			userRepository.save(user);
			
			return new UserResponseDTO(user);
	}
}
