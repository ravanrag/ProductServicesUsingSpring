package com.example.simplespring.Dtos;
import com.example.simplespring.Models.Category;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FakeStoreProductDTO {
    private double price;
    private String image;
    private String description;
    private Long id;
    private String title;
    private String category;

}
