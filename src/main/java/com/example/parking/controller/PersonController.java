package com.example.parking.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Person;
import com.example.parking.repository.PersonRepository;

@RestController
public class PersonController {
    PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping("/person")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
    }

    @GetMapping("/persons")
    public Iterable<Person> getAllPersonNames() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public Optional<Person> getOne(@PathVariable("id") Long id) {
        return personRepository.findById(id);
    }

}
