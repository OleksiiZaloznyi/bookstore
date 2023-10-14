package com.example.bookstore.service;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.CreateBookRequestDto;
import com.example.bookstore.dto.UpdateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto createBook(CreateBookRequestDto bookDto);

    List<BookDto> findAll();

    BookDto getBookById(Long id);

    List<BookDto> getAllByTitle(String title);

    BookDto updateBookById(Long id, UpdateBookRequestDto bookDto);

    void deleteById(Long id);
}
