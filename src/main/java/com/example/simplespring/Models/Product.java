package com.example.simplespring.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private double price;
    private String image;
    private String description;
    private Long id;
    private String title;

    @ManyToOne
    private Category category;
}
