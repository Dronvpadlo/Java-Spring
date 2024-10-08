package com.example.Java_Spring.carService.controller;

import com.example.Java_Spring.carService.dto.CarDTO;
import com.example.Java_Spring.carService.entity.Car;
import com.example.Java_Spring.carService.repository.CarRepository;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarRepository carRepository;
    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getCars(){
        List<Car> cars = carRepository.findAll();
        List<CarDTO> collect = cars.stream()
                .map(car -> new CarDTO(car.getId(), car.getModel(), car.getEnginePower(), car.getTorque()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id){
        return ResponseEntity.of(carRepository.findById(id));
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody @Valid CarDTO carDTO){
        Car car = new Car();
        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        car.setEnginePower(carDTO.getEnginePower());
        car.setTorque(carDTO.getTorque());
        return ResponseEntity.ok(carRepository.save(car));
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> changeCar(@PathVariable Long id, @RequestBody @Valid Car newCar){
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
