package com.nextbook.services;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nextbook.entities.Product;
import com.nextbook.entities.Sale;
import com.nextbook.entities.SaleItem;
import com.nextbook.entities.User;
import com.nextbook.repositories.ProductRepository;
import com.nextbook.repositories.SaleRepository;
import com.nextbook.repositories.UserRepository;
import com.nextbook.requests.SaleItemRequestDTO;
import com.nextbook.requests.SaleRequestDTO;
import com.nextbook.responses.SaleAllSalesResponseDTO;
import com.nextbook.responses.SaleCreatedResponseDTO;

import jakarta.transaction.Transactional;

@Service
public class SaleService {

	private final SaleRepository saleRepository;
	private final UserRepository userRepository;
	private final ProductRepository productRepository;

	public SaleService(SaleRepository saleRepository, UserRepository userRepository,
			ProductRepository productRepository) {
		this.saleRepository = saleRepository;
		this.userRepository = userRepository;
		this.productRepository = productRepository;
	}

	@Transactional
	public SaleCreatedResponseDTO registerSale(SaleRequestDTO dto) {
		User user = userRepository.findById(dto.getUserId())
				.orElseThrow(() -> new RuntimeException("User with Id: " + dto.getUserId() + " not found."));
		
		Sale sale = new Sale();
		sale.setUser(user);
		sale.setSaleDate(LocalDateTime.now());
		BigDecimal totalSale = BigDecimal.ZERO;
		List<SaleItem> saleItems = new ArrayList<>();
		
		for (SaleItemRequestDTO item : dto.getSaleItems()) {
			Product product = productRepository.findById(item.getProductId())
					.orElseThrow(() -> new RuntimeException("Product with Id: " + item.getProductId() + " not found."));
			
			SaleItem saleItem = new SaleItem();
			saleItem.setSale(sale);
			saleItem.setProduct(product);
			saleItem.setQuantity(item.getQuantity());
			saleItem.setUnitPrice(product.getPrice());
			
			saleItems.add(saleItem);
			
			BigDecimal subtotal =
                    product.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));

            totalSale = totalSale.add(subtotal);
		}
		
		sale.setTotalSale(totalSale);
		sale.setSaleItems(saleItems);
		
		saleRepository.save(sale);
		
		return new SaleCreatedResponseDTO(sale);
	}
	
	public Page<SaleAllSalesResponseDTO> findAllSales(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<Sale> sales = saleRepository.findAll(pageable);
		
		return sales.map(SaleAllSalesResponseDTO::new);
	}
}
