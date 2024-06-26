package com.productservice.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity(name ="orders")
public class Order extends BaseModel{
    @ManyToMany
    @JoinTable(name = "products_orders",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Products> products;
}

//   order   :  products
//   1   ---->  m
//   m   <----  1
//   -------------------
//   m     :     m