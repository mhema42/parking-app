package com.example.parking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.parking.entity.Car;

public interface CarRepository extends CrudRepository<Car, Long> {

}
