package com.example.simplespring.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private double price;
    private String image;
    private String description;
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Category> categoryList;
}
    