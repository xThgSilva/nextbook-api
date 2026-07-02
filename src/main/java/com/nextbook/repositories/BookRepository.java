package com.nextbook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nextbook.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
