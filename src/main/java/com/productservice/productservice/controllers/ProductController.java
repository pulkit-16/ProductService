package com.productservice.productservice.controllers;


import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    //Constructor injection
    public ProductController(@Qualifier("fakeStoreProductServiceImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        // call the FakeStoreProductServiceImpl getProductById() method

        return productService.getProductById(id);
    }

    @GetMapping()
    public List<GenericProductDto> getAllProduct() {
        return productService.getAllProduct();
    }

    @PatchMapping("/{id}")
    public GenericProductDto updateProduct(@PathVariable Long id, @RequestBody GenericProductDto genericProductDto) {
        return productService.updateProduct(id, genericProductDto);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.createProduct(genericProductDto);
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }


    //any method return this kind of exception will handle by this
//    @ExceptionHandler(ProductNotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        ResponseEntity responseEntity = new ResponseEntity(exceptionDto,HttpStatus.NOT_FOUND);
//       // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
//        return  responseEntity;
//    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    private ExceptionDto handleProductNotFoundException(ProductNotFoundException productNotFoundException){
//        ExceptionDto exceptionDto = new ExceptionDto();
//        //exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);
//        exceptionDto.setMessage(productNotFoundException.getMessage());
//        return exceptionDto;
//    }

}