package com.E_Commerce_API.Product.Service;

import com.E_Commerce_API.Product.DTO.ProductRequest;
import com.E_Commerce_API.Product.DTO.ProductResponse;
import com.E_Commerce_API.Product.Entity.Category;
import com.E_Commerce_API.Product.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product mapToProduct(ProductRequest productRequest){
        return Product.builder()
                .id(productRequest.id())
                .description(productRequest.description())
                .name(productRequest.name())
                .availableQuantity(productRequest.availableQuantity())
                .price(productRequest.price())
                .category(
                        Category.builder()
                                .id(productRequest.categoryId())
                                .build()
                )
                .build();
    }

     public ProductResponse mapToProductResponse(Product product){
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getAvailableQuantity(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }
}
