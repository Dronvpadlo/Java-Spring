package com.example.Java_Spring.carService.services;
import com.example.Java_Spring.carService.entity.Car;
import com.example.Java_Spring.carService.dto.CarDTO;
import com.example.Java_Spring.carService.repository.CarRepository;
import com.example.Java_Spring.carService.utils.CarUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class CarService {

    private CarRepository carRepository;
    private CarUtil carUtil;

    public List<CarDTO> findAll() {
        return carUtil.convertCarToDTO(carRepository.findAll());
    }

    public CarDTO findById(Long id) {
        return carUtil.convertCarToDTO(carRepository.findById(id).get());
    }

    public CarDTO saveCar (CarDTO carDTO){
        carRepository.save(carUtil.converteDTOtoCar(carDTO));
        return carDTO;
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public CarDTO putCar(Long id, CarDTO newCar){
        carRepository.findById(id)
                .map(car -> {
                    car.setModel(newCar.getModel());
                    car.setEnginePower(newCar.getEnginePower());
                    car.setTorque(newCar.getTorque());
                    return ResponseEntity.ok(carRepository.save(carUtil.converteDTOtoCar(newCar)));
                })
                .orElseGet(()->ResponseEntity.notFound().build());
        return carUtil.convertCarToDTO(carRepository.findById(id).get());
    }

    public CarDTO maxPowerCar() {
        return carRepository.findAll().stream()
                .max(Comparator.comparingInt(Car::getEnginePower))
                .map(carUtil::convertCarToDTO)
                .orElse(null);

    }
    public CarDTO minPowerCar() {
        return carRepository.findAll().stream()
                .min(Comparator.comparingInt(Car::getEnginePower))
                .map(carUtil::convertCarToDTO)
                .orElse(null);

    }
}