package com.productservice.productservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category  extends BaseModel{
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = jakarta.persistence.FetchType.EAGER, mappedBy = "category")
    private List<Products>products;

}
// in lazy it will initialize only name not list of product
//coz it has same relation with product not underlined attributes

//in eager it will initialize both