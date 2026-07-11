package com.nextbook.controllers;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextbook.requests.SaleRequestDTO;
import com.nextbook.responses.SaleAllSalesResponseDTO;
import com.nextbook.responses.SaleCreatedResponseDTO;
import com.nextbook.services.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {

	private final SaleService saleService;

	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}
	
	@PostMapping
	public ResponseEntity<SaleCreatedResponseDTO> registerSale(@RequestBody SaleRequestDTO dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(saleService.registerSale(dto));
	}
	
	@GetMapping(value = "/{page}/{size}")
	public ResponseEntity<Page<SaleAllSalesResponseDTO>> findAllSales(@PathVariable int page, @PathVariable int size) {
		return ResponseEntity.ok(saleService.findAllSales(page, size));
	}
	
	@GetMapping(value = "/{start}/{end}/{page}/{size}")
	public ResponseEntity<Page<SaleAllSalesResponseDTO>> filterSalesBetweenDate(@PathVariable LocalDate start, @PathVariable LocalDate end, 
			@PathVariable int page, @PathVariable int size) {
		return ResponseEntity.ok(saleService.filterSalesBetweenDate(page, size, start, end));
	}
}
