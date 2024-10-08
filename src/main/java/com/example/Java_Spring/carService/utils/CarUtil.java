package com.example.Java_Spring.carService.utils;

import com.example.Java_Spring.carService.dto.CarDTO;
import com.example.Java_Spring.carService.entity.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CarUtil {

    //Get All
    public List<CarDTO> convertCarToDTO(List<Car> carList){
        List<CarDTO> collect = carList.stream()
                .map(car -> new CarDTO(car.getId(), car.getModel(), car.getEnginePower(), car.getTorque()))
                .collect(Collectors
                        .toList());
        return collect;
    }
    // Get By Id
    public CarDTO convertCarToDTO(Car car){
        return new CarDTO(car.getId(), car.getModel(), car.getEnginePower(), car.getTorque());

    }

    // Post Car
    public Car converteDTOtoCar(CarDTO carDTO){
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        car.setEnginePower(carDTO.getEnginePower());
        car.setTorque(carDTO.getTorque());
        return car;
    }


}
