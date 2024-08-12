package com.example.simplespring.Controllers;

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
    public ResponseEntity<Product> getSingleProduct(@PathVariable("id") Long id){
         Product p = productService.getProductByID(id);
         if(p==null){
             return new ResponseEntity<>(p,HttpStatus.BAD_REQUEST);
         }
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping()
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long Id,@RequestBody Product product){
        return productService.replaceProduct(Id, product);
    }

}
