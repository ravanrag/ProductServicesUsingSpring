package com.example.simplespring.Services;

import com.example.simplespring.Exceptions.ProductNotFoundException;
import com.example.simplespring.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductByID(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
}
