package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Products extends BaseModel{
    private String title;
    private String description;
    private int price;
    private String image;


    @ManyToOne
    private Category category;
}
 /*
 carinality
   1  ---> 1  one product have 1 category , if multiple categories we would've taken a list of category
   m  <--- 1
---------------
   m : 1
 * Product ---- Category
 *
 * */