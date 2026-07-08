package com.nextbook.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nextbook.requests.SaleRequestDTO;
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
}
