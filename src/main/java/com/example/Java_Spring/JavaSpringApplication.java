package com.example.Java_Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringApplication.class, args);
	}
	//Створити Spring Boot аплікацію CarService (вона буде використовуватися у всіх наступних ДЗ). Створити можна тут: Spring Initializr.
	//
	//Додати ReferenceDataController (назву можна змінити), який буде повертати дані із конфігурації (application.yaml):
	//
	//GET /engine-types - повертає типи двигунів (бензиновий, дизельний, гібридний...). Використати @Value анотацію.
	//GET /fuel-types - повертає типи палива (бензин, дизель, електрика).
	//Для кожного типу палива додати список варіантів. Наприклад для бензину це А-95,А-98,А-100,
	//для дизелю - зимовий,літній,арктичний, для електрики - порожній список.
	//Використати анотацію @ConfigurationProperties
	//GET /fuel-types/{fuelName} - повертає конкретний тип палива. Відповідь повинна містити назву і список варіантів.
	//Створити 2 конфіг-профілі з різною комбінацією даних
}
