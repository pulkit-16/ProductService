package com.productservice.productservice.service;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;

import java.util.List;


public interface ProductService {
    GenericProductDto getProductById(Long id) throws ProductNotFoundException;
    List<GenericProductDto> getAllProduct();
    GenericProductDto updateProduct(Long id ,GenericProductDto genericProductDto);
    GenericProductDto  createProduct(GenericProductDto genericProductDto);
   GenericProductDto deleteProduct(Long id);
}
