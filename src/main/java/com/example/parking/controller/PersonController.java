package com.example.parking.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Person;
import com.example.parking.repository.PersonRepository;

@RestController
public class PersonController {
    PersonRepository personRepository;

    public PersonController (
        PersonRepository personRepository
    ) {
        this.personRepository = personRepository;
    }
    
    @PostMapping("/persons")
    public String addPerson(@RequestBody Person person) {
        //Validate person
        personRepository.save(person);
        return "Person saved";
    }
    
}
