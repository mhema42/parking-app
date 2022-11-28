package com.example.parking.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.parking.entity.ParkingLot;

public interface ParkingLotRepository extends ListCrudRepository<ParkingLot, Long> {

}
