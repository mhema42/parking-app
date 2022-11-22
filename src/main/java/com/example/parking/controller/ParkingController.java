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

import com.example.parking.entity.ParkingSlot;
import com.example.parking.repository.ParkingSlotRepository;

@RestController
public class ParkingController {
    ParkingSlotRepository parkingSlotRepository;

    public ParkingController (
        ParkingSlotRepository parkingSlotRepository
    ) {
        this.parkingSlotRepository = parkingSlotRepository;
    }

    @PostMapping("/parking")
    public ResponseEntity<ParkingSlot> insertOne(@RequestBody ParkingSlot parkingSlot) {
        parkingSlot.setCoordinate(point(WGS84,g(4.33,3.21)));
        var newParkingslot = parkingSlotRepository.save(parkingSlot);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newParkingslot.getId())
                .toUri();
        return ResponseEntity.created(location).body(newParkingslot);
    }

    @GetMapping("/parking")
    public List<ParkingSlot> allPoints() {
        return parkingSlotRepository.findAll();
    }

}
