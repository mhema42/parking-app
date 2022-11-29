package com.example.parking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.parking.entity.StartParking;

public interface StartParkingRepository extends CrudRepository<StartParking, Long> {
    
}