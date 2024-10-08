package com.example.Java_Spring.carService.controller;

import com.example.Java_Spring.carService.dto.CarDTO;
import com.example.Java_Spring.carService.entity.Car;
import com.example.Java_Spring.carService.repository.CarRepository;
import com.example.Java_Spring.carService.services.CarService;
import jakarta.validation.Valid;
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
    private final CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getCars(){
        return ResponseEntity.ok(carService.findAll());
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<CarDTO> getCar(@PathVariable Long id){
        return ResponseEntity.ok(carService.findById(id));
    }

    @PostMapping("/cars")
    public CarDTO createCar(@RequestBody @Valid CarDTO carDTO){
        carService.saveCar(carDTO);
        return carDTO;
    }

    @DeleteMapping("/cars")
    public ResponseEntity<List<CarDTO>> deleteCar(@RequestBody Car car){
        carService.deleteCar(car.getId());
        return ResponseEntity.ok(carService.findAll());
    }
    @PutMapping("/cars/{id}")
    public CarDTO changeCar(@PathVariable Long id, @RequestBody @Valid CarDTO newCar){
        CarDTO updatedCar = carService.putCar(id, newCar);
        return updatedCar;
    }

    @GetMapping("/cars/max-engine-power")
    public ResponseEntity<CarDTO> foundMaxPowerCar() {
        CarDTO maxPowerCar = carService.maxPowerCar();
        return ResponseEntity.ok(maxPowerCar);
    }
    @GetMapping("/cars/min-engine-power")
    public ResponseEntity<CarDTO> foundMinPowerCar() {
        CarDTO maxPowerCar = carService.minPowerCar();
        return ResponseEntity.ok(maxPowerCar);
    }
}
