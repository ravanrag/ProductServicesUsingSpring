package com.example.simplespring.Models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private double price;
    private String image;
    private String description;
    private Long id;
    private String title;
    private Category category;
}
