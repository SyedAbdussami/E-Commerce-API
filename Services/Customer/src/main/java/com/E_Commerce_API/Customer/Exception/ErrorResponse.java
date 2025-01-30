package com.E_Commerce_API.Customer.Exception;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
public class ErrorResponse {
    Map<String,String> errors;
}
