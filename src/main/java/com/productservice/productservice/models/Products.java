package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Products extends BaseModel{
    private String title;
    private String description;

    private String image;


    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;

    @OneToOne(cascade = jakarta.persistence.CascadeType.REMOVE, optional = false)
    @JoinColumn(nullable = false, unique = true)

    private Price price;

    //for every product one price is there

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