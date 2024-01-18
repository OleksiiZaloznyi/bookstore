package com.example.bookstore.dto.book;

import com.example.bookstore.validator.PriceMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class BookDto {
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    private String isbn;
    @NotNull
    @PriceMin
    private BigDecimal price;
    private String description;
    private String coverImage;
}
