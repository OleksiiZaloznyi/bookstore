package com.example.bookstore.controller;

import com.example.bookstore.dto.BookDto;
import com.example.bookstore.dto.CreateBookRequestDto;
import com.example.bookstore.dto.UpdateBookRequestDto;
import com.example.bookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "books")
public class BookController {

    private final BookService bookService;

    @PostMapping("/create")
    public BookDto createBook(@RequestBody CreateBookRequestDto bookDto) {
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

    @PutMapping("/update/{id}")
    public BookDto updateBookById(@PathVariable Long id,
                                  @RequestBody UpdateBookRequestDto bookDto) {
        return bookService.updateBookById(id, bookDto);
    }

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAll();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
