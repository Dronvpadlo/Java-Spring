package com.example.Java_Spring.Controller;


import com.example.Java_Spring.Fuel;
import com.example.Java_Spring.Properties.ReferenceDataProperties;
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

    private ReferenceDataProperties referenceDataProperties;

    public ReferenceController(ReferenceDataProperties referenceDataProperties) {
        this.referenceDataProperties = referenceDataProperties;
    }

    @GetMapping("/engine-types")
    public List<String> getEngineTypes(){
        return engineTypes;
    }

    @GetMapping("/fuels")
    public List<Fuel> getFuels(){
        return referenceDataProperties.getFuels();
    }

    @GetMapping("/fuels/{name}")
    public ResponseEntity<Fuel> getFuels(@PathVariable String name){
        Optional<Fuel> result = Optional
                .ofNullable(referenceDataProperties)
                .map(ReferenceDataProperties::getFuels)
                .stream()
                .flatMap(Collection::stream)
                .filter(fuel -> Objects.equals(fuel.getName(), name))
                .findFirst();
        return ResponseEntity.of(result);
    }

}