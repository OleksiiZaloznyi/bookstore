package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByTitleContainsIgnoreCase(String name);

    List<Book> findAllByCategoryId(Long categoryId);
}
