package com.nextbook.exceptions;

public class PasswordConflictException extends RuntimeException{
	public PasswordConflictException(String message) {
		super(message);
	}
}
