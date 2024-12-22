package com.example.simplespring.Controllers;

import com.example.simplespring.Exceptions.ProductNotFoundException;
import com.example.simplespring.Models.*;
import com.example.simplespring.Services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        Product p = productService.getProductByID(id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping({"","/"})
    public ResponseEntity<List<Product>> getAllProduct(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long Id,@RequestBody Product product){
        Product p = productService.replaceProduct(Id, product);
        return new ResponseEntity<>(p, HttpStatus.CREATED);

    }

}
