package com.nextbook.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nextbook.entities.Loan;
import com.nextbook.entities.Role;
import com.nextbook.entities.Sale;
import com.nextbook.entities.User;
import com.nextbook.exceptions.EmailAlreadyRegisteredException;
import com.nextbook.exceptions.NotFoundException;
import com.nextbook.exceptions.PasswordConflictException;
import com.nextbook.repositories.LoanRepository;
import com.nextbook.repositories.SaleRepository;
import com.nextbook.repositories.UserRepository;
import com.nextbook.requests.UserRequestDTO;
import com.nextbook.responses.LoanAllLoansResponseDTO;
import com.nextbook.responses.SaleAllSalesResponseDTO;
import com.nextbook.responses.UserAllUsersResponseDTO;
import com.nextbook.responses.UserCreatedResponseDTO;
import com.nextbook.responses.UserDetailsResponseDTO;

@Service
public class UserService {

	private final UserRepository userRepository;
	private final SaleRepository saleRepository;
	private final LoanRepository loanRepository;

	public UserService(UserRepository userRepository, SaleRepository saleRepository, LoanRepository loanRepository) {
		this.userRepository = userRepository;
		this.saleRepository = saleRepository;
		this.loanRepository = loanRepository;
	}

	// TODO - Errors pattern
	public UserCreatedResponseDTO register(UserRequestDTO dto) {
		Optional<User> emailExists = userRepository.findByEmail(dto.getEmail());
		
		if (emailExists.isPresent())
			throw new EmailAlreadyRegisteredException("E-mail already registered.");
		
		if (!dto.getPassword().equals(dto.getConfirmPassword()))
			throw new PasswordConflictException("The password confirmation must match the password.");

			User user = new User(dto);
			user.setRole(Role.USER);
			userRepository.save(user);
			
			return new UserCreatedResponseDTO(user);
	}
	
	public UserDetailsResponseDTO findUserById(Long id) {
		User user = userRepository.findById(id)
			.orElseThrow(() -> new NotFoundException("User with Id " + id + " not found."));

		return new UserDetailsResponseDTO(user);
	}
	
	public List<UserAllUsersResponseDTO> findAllUsers(){
		List<User> users = userRepository.findAll();
		return users.stream().map(UserAllUsersResponseDTO::new).toList();
	}
	
	public List<SaleAllSalesResponseDTO> findAllUserSales(Long id) {
		userRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("User with Id " + id + " not found."));
		
		List<Sale> sales = saleRepository.findByUserId(id);
		return sales.stream().map(SaleAllSalesResponseDTO::new).toList();
	}
	
	public List<LoanAllLoansResponseDTO> findAllUserLoans(Long id) {
		userRepository.findById(id)
			.orElseThrow(() -> new NotFoundException("User with Id " + id + " not found."));
		
		List<Loan> loans = loanRepository.findByUserId(id);
		return loans.stream().map(LoanAllLoansResponseDTO::new).toList();
	}
}
