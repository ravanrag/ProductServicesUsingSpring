package com.example.simplespring.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDTO {
    private Double price;
    private String image;
    private String description;
    private Long id;
    private String name;
    private String category;
}
