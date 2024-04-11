package com.productservice.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products extends BaseModel{
    private String title;
    private String description;
    private int price;
    private String image;
    private double rating;
    private Category category;
}
