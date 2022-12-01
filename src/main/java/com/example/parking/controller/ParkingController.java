package com.example.parking.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Car;
import com.example.parking.entity.ParkingLot;
import com.example.parking.entity.Person;
import com.example.parking.entity.Parking;
import com.example.parking.repository.CarRepository;
import com.example.parking.repository.ParkingLotRepository;
import com.example.parking.repository.PersonRepository;
import com.example.parking.repository.ParkingRepository;
import com.example.parking.service.ParkingService;

@RestController
public class ParkingController {
    ParkingRepository ParkingRepository;
    PersonRepository personRepository;
    CarRepository carRepository;
    ParkingLotRepository parkingLotRepository;

    public ParkingController(
            ParkingRepository ParkingRepository,
            PersonRepository personRepository,
            CarRepository carRepository,
            ParkingLotRepository parkingLotRepository) {
        this.ParkingRepository = ParkingRepository;
        this.personRepository = personRepository;
        this.carRepository = carRepository;
        this.parkingLotRepository = parkingLotRepository;
    }

    @PostMapping("/parking/{personId}/{carId}/{parkingLotId}")
    public ResponseEntity<Parking> Parking(
            @RequestBody Parking Parking,
            @PathVariable Long personId,
            @PathVariable Long carId,
            @PathVariable Long parkingLotId) {

        Person person = personRepository.findById(personId).get();
        Parking.setPerson(person);
        Car car = carRepository.findById(carId).get();
        Parking.setCar(car);
        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId).get();
        Parking.setParkingLot(parkingLot);
        LocalDateTime startTime = LocalDateTime.now();
        Parking.setParkingStart(startTime);
        Parking.setStatus("Active");

        if (ParkingService.CheckTime(Parking.getParkingEnd())) {
            //if (person.getCars().contains(car)) {
                var newParking = ParkingRepository.save(Parking);
                return ResponseEntity.ok(newParking);
            //}
        }
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/parking/{parkingId}")
    public ResponseEntity<Parking> addTime(@RequestBody Parking parkingNew, @PathVariable Long parkingId) {
        if (ParkingService.CheckTime(parkingNew.getParkingEnd())) {
            LocalDateTime NewParkingEnd = parkingNew.getParkingEnd();
            Parking parkingOld = ParkingRepository.findById(parkingId).get();
            parkingOld.setParkingEnd(NewParkingEnd);
    
            var addTimeParking = ParkingRepository.save(parkingOld);
            return ResponseEntity.ok(addTimeParking);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/parkings")
    public Iterable<Parking> getAllParkings() {
        return ParkingRepository.findAll();
    }

    @GetMapping("/parking/{parkingId}")
    public Optional<Parking> getOne(@PathVariable Long parkingId) {
        return ParkingRepository.findById(parkingId);
    }

}
