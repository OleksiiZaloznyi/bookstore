package com.example.bookstore.service;

import com.example.bookstore.dto.book.BookDto;
import com.example.bookstore.dto.book.CreateBookRequestDto;
import com.example.bookstore.dto.book.UpdateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto createBook(CreateBookRequestDto bookDto);

    List<BookDto> findAll(String email, Pageable pageable);

    BookDto getBookById(Long id);

    List<BookDto> getAllByTitle(String title);

    BookDto updateBookById(Long id, UpdateBookRequestDto bookDto);

    void deleteById(Long id);
}
