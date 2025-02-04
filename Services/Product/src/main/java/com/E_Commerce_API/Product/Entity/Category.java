package com.E_Commerce_API.Product.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category",cascade = CascadeType.REMOVE)
    List<Product> productList;
}
