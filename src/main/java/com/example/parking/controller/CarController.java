package com.example.parking.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Car;
import com.example.parking.repository.CarRepository;

@RestController
public class CarController {
    CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping("/car")
    public String addCar(@RequestBody Car car) {
        carRepository.save(car);
        return "Car saved";
    }

    @GetMapping("/car")
    public Iterable<Car> getAllCarNames() {
        return carRepository.findAll();
    }

    @GetMapping("/car/{id}")
    public Optional<Car> getOne(@PathVariable("id") Long id) {
        return carRepository.findById(id);
    }

}
