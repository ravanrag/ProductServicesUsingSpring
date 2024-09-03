package com.example.simplespring.Exceptions;

import com.example.simplespring.Models.Product;

public class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
