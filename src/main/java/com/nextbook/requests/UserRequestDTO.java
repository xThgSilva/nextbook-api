package com.nextbook.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
	
	@NotBlank(message = "Name is required.")
	@Size(max = 100, message = "Name must be at most 100 characters.")
	private String name;
	
	@NotBlank(message = "E-mail is required")
	@Email(message = "Invalid e-mail format")
	@Size(max = 50, message = "E-mail must be at most 50 characters.")
	private String email;
	
	@NotBlank(message = "Password is required")
	@Size(min = 5, max = 255, message = "Password must be between 5 and 255 characters.")
	private String password;
	
	@NotBlank(message = "Confirm password is required.")
	@Size(min = 5, message = "Confirm password be at least 5 characters.")
	private String confirmPassword;
	
	@NotBlank(message = "Phone is required.")
	@Size(min = 11, max = 11, message = "Phone must have exactly 11 digits.")
	private String phone;
	
	@NotNull(message = "Age is required.")
	@Min(value = 16, message = "You must be at least 16 years old.")
	private int age;
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public String getPhone() {
		return phone;
	}
	public int getAge() {
		return age;
	}
}
