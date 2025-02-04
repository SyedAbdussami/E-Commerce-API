package com.E_Commerce_API.Product.Controller;


import com.E_Commerce_API.Product.DTO.ProductPurchaseRequest;
import com.E_Commerce_API.Product.DTO.ProductPurchaseResponse;
import com.E_Commerce_API.Product.DTO.ProductRequest;
import com.E_Commerce_API.Product.DTO.ProductResponse;
import com.E_Commerce_API.Product.Service.ProductService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("product_id") Integer productId){
        return ResponseEntity.ok(productService.getProduct(productId));
    }

    @PostMapping("/create")
    public ResponseEntity<Integer> createProduct(@RequestBody ProductRequest productRequest){
        return ResponseEntity.ok(productService.createProduct(productRequest));
    }

//    @PostMapping("/purchase")
//    public ResponseEntity<ProductPurchaseResponse> purchaseProduct(@RequestBody ProductPurchaseRequest productPurchaseRequest){
//        return ResponseEntity.ok(productService.purchaseProduct(productPurchaseRequest));
//    }
}
