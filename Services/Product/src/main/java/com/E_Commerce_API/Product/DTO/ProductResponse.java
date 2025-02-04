package com.E_Commerce_API.Product.DTO;

import com.E_Commerce_API.Product.Entity.Category;

import java.math.BigInteger;

public record ProductResponse(
        Integer id,
        String name,
        String description,
        BigInteger price,
        double availableQuantity,
        Integer categoryId,
        String categoryDescription,
        String CategoryName
) {
}
