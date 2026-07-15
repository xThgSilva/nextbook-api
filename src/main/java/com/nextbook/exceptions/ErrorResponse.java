package com.nextbook.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {
	private LocalDateTime timestamp;
	private int code;
	private String error;
	private String message;
	
	public ErrorResponse(LocalDateTime timestamp, int code, String error, String message) {
		this.timestamp = timestamp;
		this.code = code;
		this.error = error;
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public int getCode() {
		return code;
	}
	public String getError() {
		return error;
	}
	public String getMessage() {
		return message;
	}
}
