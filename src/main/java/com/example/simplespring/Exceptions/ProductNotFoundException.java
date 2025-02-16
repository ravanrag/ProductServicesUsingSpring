package com.example.simplespring.Exceptions;

import com.example.simplespring.Models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception {
    private Long productId;
    private String message;
    public ProductNotFoundException(String message, Long productId) {
        super(message);
        this.productId = productId;
    }
}