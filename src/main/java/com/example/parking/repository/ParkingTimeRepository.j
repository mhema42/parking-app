package com.example.parking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.parking.entity.ParkingTime;

public interface ParkingTimeRepository extends CrudRepository<ParkingTime, Long> {
    
}
