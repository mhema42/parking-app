package com.example.parking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Car;
import com.example.parking.repository.CarRepository;

@RestController
public class CarController {
    CarRepository carRepository;

    public CarController (
        CarRepository carRepository
    ) {
        this.carRepository = carRepository;
    }

    @PostMapping("/car")
    public String addCar(@RequestBody Car car) {
        //Validate car
        carRepository.save(car);
        return "Car saved";
    }
    
}
