package com.nextbook.responses;

import com.nextbook.entities.User;

public class UserDetailsResponseDTO extends UserBaseResponseDTO{
	private String phone;
	private int age;
	
	public UserDetailsResponseDTO(User user) {
		super(user);
		this.phone = user.getPhone();
		this.age = user.getAge();
	}
	
	public String getPhone() {
		return phone;
	}
	public int getAge() {
		return age;
	}
}
