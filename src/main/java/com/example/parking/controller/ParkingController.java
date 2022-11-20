package com.example.parking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Car;
import com.example.parking.entity.ParkingSlot;
import com.example.parking.entity.ParkingTime;
import com.example.parking.entity.Person;
import com.example.parking.repository.CarRepository;
import com.example.parking.repository.ParkingSlotRepository;
import com.example.parking.repository.ParkingTimeRepository;
import com.example.parking.repository.PersonRepository;

@RestController
public class ParkingController {

    PersonRepository personRepository;
    CarRepository carRepository;
    ParkingSlotRepository parkingSlotRepository;
    ParkingTimeRepository parkingTimeRepository;

    public ParkingController (
        PersonRepository personRepository, 
        CarRepository carRepository,
        ParkingSlotRepository parkingSlotRepository,
        ParkingTimeRepository parkingTimeRepository
    ) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
        this.parkingSlotRepository = parkingSlotRepository;
        this.parkingTimeRepository = parkingTimeRepository;
    }
    
    @PostMapping("/persons")
    public String addPerson(@RequestBody Person person) {
        //Validate person
        personRepository.save(person);
        return "Person saved";
    }

    @PostMapping("/car")
    public String addCar(@RequestBody Car car) {
        //Validate car
        carRepository.save(car);
        return "Car saved";
    }

    @PostMapping("/parking")
    public String addParking(@RequestBody ParkingSlot parkingSlot) {
        //Validate parkingSlot
        parkingSlotRepository.save(parkingSlot);
        return "Parking Slot saved";
    }

    @PostMapping("/time")
    public String addTime(@RequestBody ParkingTime parkingTime) {
        //Validate parkingTime
        parkingTimeRepository.save(parkingTime);
        return "Parking Time saved";
    }

}
