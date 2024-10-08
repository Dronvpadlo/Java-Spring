package com.example.Java_Spring.carService.controller;


import com.example.Java_Spring.carService.entity.FuelType;
import com.example.Java_Spring.carService.properties.ReferenceDataProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/reference-data")
public class ReferenceController {
    @Value("${reference-data.engineTypes}")
    private List<String> engineTypes;

    private final ReferenceDataProperties referenceDataProperties;

    public ReferenceController(ReferenceDataProperties referenceDataProperties) {
        this.referenceDataProperties = referenceDataProperties;
    }

    @GetMapping("/engine-types")
    public List<String> getEngineTypes(){
        return engineTypes;
    }

    @GetMapping("/fuels")
    public List<FuelType> getFuels(){
        return referenceDataProperties.getFuels();
    }

    @GetMapping("/fuels/{name}")
    public ResponseEntity<FuelType> getFuels(@PathVariable String name){
        Optional<FuelType> result = Optional
                .ofNullable(referenceDataProperties)
                .map(ReferenceDataProperties::getFuels)
                .stream()
                .flatMap(Collection::stream)
                .filter(fuel -> Objects.equals(fuel.getName(), name))
                .findFirst();
        return ResponseEntity.of(result);
    }

}