package com.productservice.productservice.repository;

import com.productservice.productservice.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<Products, UUID> {
    @Override
     Products save(Products products);
}
