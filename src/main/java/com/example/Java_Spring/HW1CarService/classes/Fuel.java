package com.example.Java_Spring.HW1CarService.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fuel {
    private String name;
    private List<String> types;
}
