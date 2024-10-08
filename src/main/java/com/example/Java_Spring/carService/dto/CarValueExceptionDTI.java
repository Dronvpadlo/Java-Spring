package com.example.Java_Spring.carService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CarValueExceptionDTI {

    private int code;
    private String field;
    private String message;
}
