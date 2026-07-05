package com.nextbook.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nextbook.entities.Book;
import com.nextbook.entities.Product;
import com.nextbook.repositories.BookRepository;
import com.nextbook.repositories.ProductRepository;
import com.nextbook.requests.BookRequestDTO;
import com.nextbook.responses.BookFindDetailsResponseDTO;
import com.nextbook.responses.BookResponseDTO;

import jakarta.transaction.Transactional;
@Service
public class BookService {

	private final BookRepository bookRepository;
	private final ProductRepository productRepository;

	public BookService(BookRepository bookRepository, ProductRepository productRepository) {
		this.bookRepository = bookRepository;
		this.productRepository = productRepository;
	}

	@Transactional
	public BookResponseDTO registerBook(BookRequestDTO dto) {
		Product product = new Product(dto);
		productRepository.save(product);
		
		Book book = new Book(dto);
		book.setProduct(product);
		bookRepository.save(book);
		
		return new BookResponseDTO(book);
	}
	
	public BookFindDetailsResponseDTO findBookById(Long id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Book with Id " + id + " not found."));
		
		return new BookFindDetailsResponseDTO(book);
	}
	
	public Page<BookResponseDTO> findAllBooks(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Book> books = bookRepository.findAll(pageable);
		
		return books.map(BookResponseDTO::new);
	}
	
	public void deleteBookById(Long id) {
	    Book book = bookRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Book with Id: " + id + " not found."));
	        
	    bookRepository.delete(book);
	}
}
