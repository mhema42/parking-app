package com.example.parking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.parking.entity.ParkingSlot;

public interface ParkingSlotRepository extends CrudRepository<ParkingSlot, Long> {
   
}
