package com.nextbook.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalHandlerExceptions {

	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors()
            .forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);
    }
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex, HttpServletResponse servlet) {
		ErrorResponse error = new ErrorResponse(
				HttpStatus.NOT_FOUND.value(),
				"Not Found.",
				ex.getMessage()
				);
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailAlreadyRegisteredException.class)
	public ResponseEntity<ErrorResponse> handleEmailAlreadyRegisted(EmailAlreadyRegisteredException ex, HttpServletResponse servlet) {
		ErrorResponse error = new ErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				"Bad Request.",
				ex.getMessage()
				);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PasswordConflictException.class)
	public ResponseEntity<ErrorResponse> handlePasswordConflict(PasswordConflictException ex, HttpServletResponse servlet) {
		ErrorResponse error = new ErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				"Bad Request.",
				ex.getMessage()
				);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidStatusBookException.class)
	public ResponseEntity<ErrorResponse> handleInvalidStausBook(InvalidStatusBookException ex, HttpServletResponse servlet) {
		ErrorResponse error = new ErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				"Bad Request.",
				ex.getMessage()
				);
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
