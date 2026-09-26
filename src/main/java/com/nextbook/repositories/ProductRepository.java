package com.nextbook.repositories;

import com.nextbook.entities.Availability;
import com.nextbook.entities.Category;
import com.nextbook.responses.ProductAllProductsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.nextbook.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    @Query("""
    SELECT p FROM Product p 
    LEFT JOIN FETCH p.book b
    WHERE p.name LIKE CONCAT(:searchName, '%')
    AND (:isBook = false OR b IS NOT NULL)
    AND (:categories IS NULL OR b.category IN :categories)
    AND (:availability IS NULL OR b.availability = :availability)
""")
    Page<Product> findByFilters(
            @Param("searchName") String searchName,
            @Param("isBook") Boolean isBook,
            @Param("categories") Category[] categories,
            @Param("availability") Availability availability,
            Pageable pageable
    );
}
