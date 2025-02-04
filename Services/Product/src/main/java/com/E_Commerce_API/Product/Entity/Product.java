package com.E_Commerce_API.Product.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Product {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;

    private BigInteger price;

    private double availableQuantity;
    @ManyToOne
    @JoinColumn(name = "category_id")
    Category category;

}
