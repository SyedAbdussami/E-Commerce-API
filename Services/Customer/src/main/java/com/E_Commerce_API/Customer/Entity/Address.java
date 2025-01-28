package com.E_Commerce_API.Customer.Entity;

import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Validated
@Builder
public class Address {

    private String street;
    private String houseNumber;
    private String zipCode;
}
