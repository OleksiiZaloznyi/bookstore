package com.example.bookstore.service;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.CreateBookRequestDto;
import com.example.bookstore.dto.UpdateBookRequestDto;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BookService {
    BookDto createBook(CreateBookRequestDto bookDto);

    List<BookDto> findAll(Pageable pageable);

    BookDto getBookById(Long id);

    List<BookDto> getAllByTitle(String title);

    BookDto updateBookById(Long id, UpdateBookRequestDto bookDto);

    void deleteById(Long id);
}
