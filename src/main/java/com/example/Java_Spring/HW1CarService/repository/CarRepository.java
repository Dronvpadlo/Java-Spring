package com.example.Java_Spring.HW1CarService.repository;

import com.example.Java_Spring.HW1CarService.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
