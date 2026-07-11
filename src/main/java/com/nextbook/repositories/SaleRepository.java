package com.nextbook.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextbook.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
	List<Sale> findByUserId(Long id);
	Page<Sale> findBySaleDateBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}
