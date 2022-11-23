package com.example.parking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.ParkingTime;
import com.example.parking.repository.ParkingTimeRepository;

@RestController
public class ParkingTimeController {
    ParkingTimeRepository parkingTimeRepository;

    public ParkingTimeController (
        ParkingTimeRepository parkingTimeRepository
    ) {
        this.parkingTimeRepository = parkingTimeRepository;
    }

    @PostMapping("/time")
    public String addTime(@RequestBody ParkingTime parkingTime) {
        //Validate time
        parkingTimeRepository.save(parkingTime);
        return "Parking Time saved";
    }
    
    @GetMapping("/times")
    public Iterable<ParkingTime> getAllParkingTimeNames(){
        return parkingTimeRepository.findAll();
    }
}
