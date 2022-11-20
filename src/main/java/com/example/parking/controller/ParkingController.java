package com.example.parking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.ParkingSlot;
import com.example.parking.entity.Person;
import com.example.parking.repository.ParkingSlotRepository;
import com.example.parking.repository.PersonRepository;

@RestController
public class ParkingController {

    PersonRepository personRepository;
    ParkingSlotRepository parkingSlotRepository;

    public ParkingController(PersonRepository personRepository, ParkingSlotRepository parkingSlotRepository) {
        this.personRepository = personRepository;
        this.parkingSlotRepository = parkingSlotRepository;
    }
    
    @PostMapping("/persons")
    public String addPerson(@RequestBody Person person) {
        //Validate person
        personRepository.save(person);
        return "Person saved";
    }

    @PostMapping("/parking")
    public String addParking(@RequestBody ParkingSlot parkingSlot) {
        //Validate parkingSlot
        parkingSlotRepository.save(parkingSlot);
        return "Parking Slot saved";
    }

}
