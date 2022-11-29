package com.example.parking.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Car;
import com.example.parking.entity.ParkingLot;
import com.example.parking.entity.Person;
import com.example.parking.entity.StartParking;
import com.example.parking.repository.CarRepository;
import com.example.parking.repository.ParkingLotRepository;
import com.example.parking.repository.PersonRepository;
import com.example.parking.repository.StartParkingRepository;

@RestController
public class StartParkingController {
    StartParkingRepository startParkingRepository;
    PersonRepository personRepository;
    CarRepository carRepository;
    ParkingLotRepository parkingLotRepository;

    public StartParkingController(
        StartParkingRepository startParkingRepository, 
        PersonRepository personRepository, 
        CarRepository carRepository,
        ParkingLotRepository parkingLotRepository
    ) {
        this.startParkingRepository = startParkingRepository;
        this.personRepository = personRepository;
        this.carRepository = carRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    @PostMapping("/pstart/{person_id}/{car_id}/{parking_lot_id}")
        public ResponseEntity<StartParking> startParking(
            @RequestBody StartParking startParking, 
            @PathVariable Long person_id,
            @PathVariable Long car_id,
            @PathVariable Long parking_lot_id
        ) {
        
        Person person = personRepository.findById(person_id).get();
        startParking.setPerson(person);

        Car car = carRepository.findById(car_id).get();
        startParking.setCar(car);

        ParkingLot parkingLot = parkingLotRepository.findById(parking_lot_id).get();
        startParking.setParkingLot(parkingLot);
        
        LocalDateTime startTime = LocalDateTime.now();
        startParking.setParkingStart(startTime);
 
        var newStartParking = startParkingRepository.save(startParking);
        return ResponseEntity.ok(newStartParking);
    }

    @GetMapping("/pstart")
    public Iterable<StartParking> getAllParkings() {
        return startParkingRepository.findAll();
    }

    @GetMapping("/pstart/{id}")
        public Optional<StartParking> getOne(@PathVariable("id") Long id) {
            return startParkingRepository.findById(id);
    }

}
