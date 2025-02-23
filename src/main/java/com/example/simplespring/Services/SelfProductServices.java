package com.example.simplespring.Services;

import com.example.simplespring.Dtos.ProductUpdateDTO;
import com.example.simplespring.Exceptions.ProductNotFoundException;
import com.example.simplespring.Models.Category;
import com.example.simplespring.Models.Product;
import com.example.simplespring.Repos.CategoryRepo;
import com.example.simplespring.Repos.ProductRepo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductServices")
public class SelfProductServices implements ProductService{

    private final CategoryRepo categoryRepo;
    ProductRepo productRepo;

    public SelfProductServices(ProductRepo productRepo, CategoryRepo categoryRepo){
        this.productRepo=productRepo;
        this.categoryRepo = categoryRepo;
    }
    @Override
    public Product getProductByID(Long id) throws ProductNotFoundException {
        return productRepo.findById(id).get();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, ProductUpdateDTO product) throws ProductNotFoundException {
        return null;
    }

    @Override
    public boolean deleteProduct(Long id) throws ProductNotFoundException {
        return false;
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();
        if(category.getId()==null) {
            Category existingCategory = categoryRepo.findByName(category.getName());
            if (existingCategory != null) {
                category = existingCategory;
            } else {
                category = categoryRepo.save(category);
            }
            Category savedCategory = categoryRepo.save(category);
            product.setCategory(savedCategory);
        }
        //cannot save new category that comes with "id". As Category ID is auto generated.
        return productRepo.save(product);

    }
}