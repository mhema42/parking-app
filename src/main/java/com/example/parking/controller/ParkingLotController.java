package com.example.parking.controller;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.parking.entity.ParkingLot;
import com.example.parking.repository.ParkingLotRepository;

@RestController
public class ParkingLotController {
    ParkingLotRepository parkingLotRepository;

    public ParkingLotController (
        ParkingLotRepository parkingLotRepository
    ) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @PostMapping("/parking")
    public ResponseEntity<ParkingLot> insertOne(@RequestBody ParkingLot parkingLot) {
        parkingLot.setCoordinate(point(WGS84,g(1,1)));
        var newParkingLot = parkingLotRepository.save(parkingLot);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newParkingLot.getId())
                .toUri();
                
        return ResponseEntity.created(location).body(newParkingLot);
    }

    @GetMapping("/parkings")
    public List<ParkingLot> allPoints() {
        return parkingLotRepository.findAll();
    }

}
