package com.nextbook.responses;

import com.nextbook.entities.User;

public class UserBaseResponseDTO {
	private Long id;
	private String name;
	private String email;
	
	public UserBaseResponseDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
	}

	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
}
