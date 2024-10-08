package com.example.Java_Spring.carService.controller;

import com.example.Java_Spring.carService.dto.CarValueExceptionDTI;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CarValueExceptionDTI valueException (MethodArgumentNotValidException ex){

        return new CarValueExceptionDTI(400, ex.getFieldError().getField(), ex.getFieldError().getDefaultMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public String valueExceptionDTI (NoSuchElementException ex){

        return "Car with this id not Found";
    }


}
