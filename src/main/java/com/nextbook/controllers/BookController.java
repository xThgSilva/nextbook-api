package com.nextbook.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nextbook.entities.Book;
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
		BookResponseDTO bookResponse = bookService.registerBook(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookResponse);
	}
	
	@GetMapping(value = "/find/{id}")
	public ResponseEntity<BookFindDetailsResponseDTO> findBook(@PathVariable Long id) {
		return ResponseEntity.ok(bookService.findBookById(id));
	}
	
	@GetMapping(value = "/all/{page}/{size}")
	public ResponseEntity<Page<BookResponseDTO>> findAllBooks(@PathVariable int page, @PathVariable int size) {
		return ResponseEntity.ok(bookService.findAllBooks(page, size));
	}
	
	@DeleteMapping(value = "/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteBookById(@PathVariable Long id) {
		bookService.deleteBookById(id);
	}
}
