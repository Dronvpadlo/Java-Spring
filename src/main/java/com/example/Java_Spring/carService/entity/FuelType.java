package com.example.Java_Spring.carService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuelType {

    private String name;

    private List<String> types;


}
