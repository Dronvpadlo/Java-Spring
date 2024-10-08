package com.example.Java_Spring.carService.services;

import com.example.Java_Spring.carService.dto.CarDTO;
import com.example.Java_Spring.carService.entity.Car;
import com.example.Java_Spring.carService.repository.CarRepository;
import com.example.Java_Spring.carService.utils.CarUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    /*public CarDTO putCar(Long id, Car newCar){
        carRepository.findById(id)
                .map(car -> {
                    car.setModel(newCar.getModel());
                    car.setEnginePower(newCar.getEnginePower());
                    car.setTorque(newCar.getTorque());
                    return ResponseEntity.ok(carRepository.save(car));
                })
                .orElseGet(()->ResponseEntity.notFound().build());
        return carUtil.convertCarToDTO(carRepository.findById(id).get());
    }*/
}
