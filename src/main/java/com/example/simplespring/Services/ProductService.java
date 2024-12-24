package com.example.simplespring.Services;

import com.example.simplespring.Dtos.ProductNotFoundExceptionDTO;
import com.example.simplespring.Dtos.ProductUpdateDTO;
import com.example.simplespring.Exceptions.ProductNotFoundException;
import com.example.simplespring.Models.Product;

import java.util.List;

public interface ProductService {
    Product getProductByID(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Product replaceProduct(Long id, Product product);
    Product updateProduct(Long id, ProductUpdateDTO product) throws ProductNotFoundException;
    boolean deleteProduct(Long id) throws ProductNotFoundException;
}
