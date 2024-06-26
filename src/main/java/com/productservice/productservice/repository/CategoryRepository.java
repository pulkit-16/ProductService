package com.productservice.productservice.repository;

import com.productservice.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    @Override
      Category save(Category category);
}
