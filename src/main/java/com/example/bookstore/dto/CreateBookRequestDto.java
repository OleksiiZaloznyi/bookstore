package com.example.bookstore.dto;

import com.example.bookstore.validator.PriceMin;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    @NotNull
    private String title;
    @NotNull
    private String author;
    @NotNull
    @PriceMin
    private BigDecimal price;
    private String description;
    private String coverImage;
}
