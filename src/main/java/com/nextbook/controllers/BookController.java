package com.nextbook.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nextbook.requests.BookRequestDTO;
import com.nextbook.responses.BookFindDetailsResponseDTO;
import com.nextbook.responses.BookResponseDTO;
import com.nextbook.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping(value = "/register")
	public ResponseEntity<BookResponseDTO> registerBook(@RequestBody BookRequestDTO dto) {
		return ResponseEntity.ok(bookService.registerBook(dto));
	}
	
	@GetMapping(value = "/find/{id}")
	public ResponseEntity<BookFindDetailsResponseDTO> findBook(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.findBookById(id));
	}
}
