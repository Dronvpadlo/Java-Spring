package com.example.Java_Spring.HW1CarService.controller;

import com.example.Java_Spring.HW1CarService.entity.Car;
import com.example.Java_Spring.HW1CarService.repository.CarRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;
    @GetMapping("/cars")
    public List<Car> getCars(){
        return carRepository.findAll();
    }

    @PostMapping("/cars")
    public Car createCar(@RequestBody Car car){
        return carRepository.save(car);
    }

    @DeleteMapping("/cars")
    public List<Car> deleteCar(@RequestBody Car car){
        carRepository.deleteById(car.getId());
        return carRepository.findAll();
    }

}
