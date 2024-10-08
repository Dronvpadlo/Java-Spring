package com.example.Java_Spring.carService.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String model;


    private Integer enginePower;


    private Integer torque;

    @Embedded
    private FuelType fuelType;
}
