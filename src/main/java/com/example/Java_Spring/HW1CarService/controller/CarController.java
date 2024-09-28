package com.example.Java_Spring.HW1CarService.controller;

import com.example.Java_Spring.HW1CarService.entity.Car;
import com.example.Java_Spring.HW1CarService.repository.CarRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Data
@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getCars(){
        return ResponseEntity.ok(carRepository.findAll());
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id){
        return ResponseEntity.of(carRepository.findById(id));
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        return ResponseEntity.ok(carRepository.save(car));
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> changeCar(@PathVariable Long id, @RequestBody Car newCar){
        return carRepository.findById(id)
                .map(car -> {
                    car.setModel(newCar.getModel());
                    car.setEnginePower(newCar.getEnginePower());
                    return ResponseEntity.ok(carRepository.save(car));
                })
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/cars")
    public ResponseEntity<List<Car>> deleteCar(@RequestBody Car car){
        carRepository.deleteById(car.getId());
        return ResponseEntity.ok(carRepository.findAll());
    }

    @GetMapping("/cars/max-engine-power")
    public ResponseEntity<Car> foundMaxPowerCar(){
        return carRepository.findAll()
                .stream()
                .max((o1, o2) -> o1.getEnginePower().compareTo(o2.getEnginePower()))
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @GetMapping("/cars/min-engine-power")
    public ResponseEntity<Car> foundMinPowerCar(){
        return carRepository.findAll()
                .stream()
                .min(((o1, o2) -> o1.getEnginePower().compareTo(o2.getEnginePower())))
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
