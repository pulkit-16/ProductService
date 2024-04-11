package com.productservice.productservice.exceptions;

import com.productservice.productservice.dtos.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}
