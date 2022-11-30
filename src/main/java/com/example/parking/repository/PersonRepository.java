package com.example.parking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.parking.entity.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}
