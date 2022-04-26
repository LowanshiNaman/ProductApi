package com.learn.product.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public  ResponseEntity<String> handleProductNotFound(ProductNotFoundException exception){
        return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<String> ProductExists(ProductAlreadyExistsException exception){
        return new ResponseEntity<>("Already exists", HttpStatus.CONFLICT);
    }

}
