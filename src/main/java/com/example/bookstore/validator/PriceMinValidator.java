package com.example.bookstore.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class PriceMinValidator implements ConstraintValidator<PriceMin, BigDecimal> {
    @Override
    public boolean isValid(
            BigDecimal price,
            ConstraintValidatorContext constraintValidatorContext
    ) {
        return price.compareTo(BigDecimal.ZERO) >= 0;
    }
}
