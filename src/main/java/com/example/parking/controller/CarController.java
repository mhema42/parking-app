package com.example.parking.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Car;
import com.example.parking.repository.CarRepository;
import com.example.parking.repository.PersonRepository;
import com.example.parking.service.CarService;

@RestController
public class CarController {
    CarRepository carRepository;
    PersonRepository personRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping("/car")
    public String addCar(@RequestBody Car car) {
        if (CarService.CheckRegNr(car.getRegNr())) {
            carRepository.save(car);
            return "Car saved";
        }
        return "U must enter valid regNr";
    }

    @GetMapping("/cars")
    public Iterable<Car> getAllCarNames() {
        return carRepository.findAll();
    }

    @GetMapping("/car/{carId}")
    public Optional<Car> getOne(@PathVariable Long carId) {
        return carRepository.findById(carId);
    }

    @PatchMapping("/car/{carId}/{personId}")
    public String addPerson(@PathVariable Long carId, @PathVariable Long personId) {
        Car car = carRepository.findById(carId).get();
        car.setPerson_id(personId);
        carRepository.save(car);
        return "Add person to car";
    }

}
