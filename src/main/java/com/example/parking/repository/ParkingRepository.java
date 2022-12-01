package com.example.parking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.parking.entity.Parking;

public interface ParkingRepository extends CrudRepository<Parking, Long> {

}