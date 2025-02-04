package com.E_Commerce_API.Product.DTO;

import java.math.BigInteger;

public record ProductPurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigInteger price,
        double quantity
) {
}
