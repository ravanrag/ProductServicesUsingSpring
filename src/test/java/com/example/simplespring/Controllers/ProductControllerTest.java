package com.example.simplespring.Controllers;

import com.example.simplespring.Exceptions.ProductNotFoundException;
import com.example.simplespring.Models.Product;
import com.example.simplespring.Services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;

    @MockBean(name = "SelfProductServices")
    ProductService productService;

    @Test
    void TestingGetProductByIDFeature() throws ProductNotFoundException {
        long id =1l;
        Product product =new Product();
        product.setName("Title");
        product.setId(1l);
        when(productService.getProductByID(1l)).thenReturn(product);
        Product p = productController.getSingleProduct(id).getBody();
        Assertions.assertEquals(1l,p.getId());
    }


}