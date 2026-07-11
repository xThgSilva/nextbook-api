package com.nextbook.responses;

import com.nextbook.entities.User;

public class UserCreatedResponseDTO extends UserBaseResponseDTO{
	public UserCreatedResponseDTO(User user) {
		super(user);
	}
}
