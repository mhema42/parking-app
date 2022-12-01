package com.example.parking.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.parking.entity.ParkingLot;
import com.example.parking.repository.ParkingLotRepository;

@RestController
public class ParkingLotController {
    ParkingLotRepository parkingLotRepository;

    public ParkingLotController(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @PostMapping("/lot")
    public ResponseEntity<ParkingLot> insertOne(@RequestBody ParkingLot parkingLot) {
        var newParkingLot = parkingLotRepository.save(parkingLot);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newParkingLot.getId())
                .toUri();

        return ResponseEntity.created(location).body(newParkingLot);
    }

    @GetMapping("/lots")
    public List<ParkingLot> allPoints() {
        return parkingLotRepository.findAll();
    }

    @GetMapping("/lot/{id}")
    public Optional<ParkingLot> getOne(@PathVariable Long lotId) {
        return parkingLotRepository.findById(lotId);
    }

}
