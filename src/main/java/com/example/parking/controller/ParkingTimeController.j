package com.example.parking.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.ParkingTime;
import com.example.parking.repository.ParkingTimeRepository;
import com.example.parking.service.ParkingTimeService;

@RestController
public class ParkingTimeController {
    ParkingTimeRepository parkingTimeRepository;

    public ParkingTimeController(
            ParkingTimeRepository parkingTimeRepository) {
        this.parkingTimeRepository = parkingTimeRepository;
    }

    @PostMapping("/time")
    public String addTime(@RequestBody ParkingTime parkingTime) {
        if (ParkingTimeService.CheckTime(parkingTime)) {
            return "Parking Time is in the past";
        }
        parkingTimeRepository.save(parkingTime);
        return "Parking Time saved";
    }

    @GetMapping("/times")
    public Iterable<ParkingTime> getAllParkingTimeNames() {
        return parkingTimeRepository.findAll();
    }

    @GetMapping("/time/{id}")
    public Optional<ParkingTime> getOne(@PathVariable("id") Long id) {
        return parkingTimeRepository.findById(id);
    }

}
