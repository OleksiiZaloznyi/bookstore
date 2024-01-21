package com.example.bookstore.controller;

import com.example.bookstore.dto.book.BookDto;
import com.example.bookstore.dto.book.CreateBookRequestDto;
import com.example.bookstore.dto.book.UpdateBookRequestDto;
import com.example.bookstore.model.User;
import com.example.bookstore.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Book Management", description = "Endpoints for managing books")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "books")
public class BookController {
    private final BookService bookService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create a new book", description = "create a new book")
    public BookDto createBook(@RequestBody @Valid CreateBookRequestDto bookDto) {
        return bookService.createBook(bookDto);
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/by-title")
    public List<BookDto> getAllByTitle(@RequestParam String title) {
        return bookService.getAllByTitle(title);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/update/{id}")
    public BookDto updateBookById(@PathVariable Long id,
                                  @RequestBody @Valid UpdateBookRequestDto bookDto) {
        return bookService.updateBookById(id, bookDto);
    }

    @GetMapping
    @Operation(summary = "Get all books", description = "Get a list of all available books")
    public List<BookDto> getAll(Authentication authentication, Pageable pageable) {
        User user = (User) authentication.getPrincipal();
        return bookService.findAll(user.getEmail(), pageable);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
