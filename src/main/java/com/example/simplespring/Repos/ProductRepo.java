package com.example.simplespring.Repos;

import com.example.simplespring.Dtos.ProductUpdateDTO;
import com.example.simplespring.Models.Product;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository <Product, Long>{
    @Modifying
    @Query("delete from Product p where p.id = :id")
    int deleteProductById(@Param("id") Long id);
}
