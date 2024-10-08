package com.example.Java_Spring.carService.dto;

import com.example.Java_Spring.carService.entity.FuelType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private Long id;

    @Size(min = 2, message = "Model must have more than 1 symbol")
    @Size(max = 254, message = "Model can not be longer than 254 symbols")
    private String model;

    @Min(value = 1, message = "Engine Power must be min 1")
    private Integer enginePower;

    @Min(value = 1, message = "Torque must be min 1")
    private Integer torque;

    private FuelType fuelType;
}
