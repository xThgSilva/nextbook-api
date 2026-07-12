package com.nextbook.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nextbook.requests.BookRequestDTO;
import com.nextbook.responses.BookResponseDTO;
import com.nextbook.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping
	public ResponseEntity<BookResponseDTO> registerBook(@RequestBody BookRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.registerBook(dto));
	}
	
	@GetMapping(value = "/{page}/{size}")
	public ResponseEntity<Page<BookResponseDTO>> findAllBooks(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int size) {
		return ResponseEntity.ok(bookService.findAllBooks(page, size));
	}
}