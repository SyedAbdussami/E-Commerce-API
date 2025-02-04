package com.E_Commerce_API.Product.Service;

import com.E_Commerce_API.Product.DTO.ProductRequest;
import com.E_Commerce_API.Product.DTO.ProductResponse;
import com.E_Commerce_API.Product.Repository.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;

    public List<ProductResponse> getAllProducts(){
        return productRepo.findAll().stream().map(productMapper::mapToProductResponse).collect(Collectors.toList());
    }

    public ProductResponse getProduct(int productId){
        return productRepo.findById(productId).map(productMapper::mapToProductResponse).orElseThrow();
    }

    public Integer createProduct(ProductRequest productRequest){
        var product=productMapper.mapToProduct(productRequest);
       return productRepo.save(product).getId();
    }
}
