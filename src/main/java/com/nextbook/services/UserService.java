package com.nextbook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nextbook.entities.Sale;
import com.nextbook.entities.User;
import com.nextbook.repositories.SaleRepository;
import com.nextbook.repositories.UserRepository;
import com.nextbook.requests.UserRequestDTO;
import com.nextbook.responses.SaleAllSalesResponseDTO;
import com.nextbook.responses.UserCreatedResponseDTO;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final SaleRepository saleRepository;

	public UserService(UserRepository userRepository, SaleRepository saleRepository) {
		this.userRepository = userRepository;
		this.saleRepository = saleRepository;
	}

	// TODO - Errors pattern
	public UserCreatedResponseDTO register(UserRequestDTO dto) {
		Optional<User> emailExists = userRepository.findByEmail(dto.getEmail());
		
		if (emailExists.isPresent())
			throw new RuntimeException("E-mail already registered.");
		
		if (!dto.getPassword().equals(dto.getConfirmPassword()))
			throw new RuntimeException("The password confirmation must match the password.");

			User user = new User(dto);
			userRepository.save(user);
			
			return new UserCreatedResponseDTO(user);
	}
	
	public List<SaleAllSalesResponseDTO> findAllUserSales(Long id) {
		userRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("User with Id: " + id + " not found."));
		
		List<Sale> sales = saleRepository.findByUserId(id);
		return sales.stream().map(SaleAllSalesResponseDTO::new).toList();
	}
}
