package com.nextbook.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextbook.entities.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	List<Loan> findByUserId(Long id);
}
