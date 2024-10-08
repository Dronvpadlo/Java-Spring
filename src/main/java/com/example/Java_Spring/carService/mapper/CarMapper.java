package com.example.Java_Spring.carService.mapper;

import com.example.Java_Spring.carService.dto.CarDTO;
import com.example.Java_Spring.carService.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarDTO mapToDTO(Car car){
        CarDTO dto = new CarDTO();
        dto.setId(car.getId());
        dto.setModel(car.getModel());
        dto.setEnginePower(car.getEnginePower());
        dto.setTorque(car.getTorque());
        return dto;
    }

}
