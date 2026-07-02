package com.nextbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nextbook.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
