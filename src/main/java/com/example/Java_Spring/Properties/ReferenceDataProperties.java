package com.example.Java_Spring.Properties;
import com.example.Java_Spring.Fuel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "reference-data")
public class ReferenceDataProperties {
    private List<Fuel> fuels;
}
