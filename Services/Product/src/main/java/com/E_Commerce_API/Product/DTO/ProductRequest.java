package com.E_Commerce_API.Product.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.math.BigInteger;

public record ProductRequest(
        Integer id,
        @NotNull(message = "Product name is required")
        String name,
        @NotNull(message = "Product description is required")
        String description,
        @Positive(message = "Available quantity should be positive")
        double availableQuantity,
        @Positive(message = "Price should be positive")
        BigInteger price,
        @NotNull(message = "Product category is required")
        Integer categoryId
) {
}
