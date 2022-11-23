package com.example.parking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.parking.entity.Car;
import com.example.parking.entity.Person;
import com.example.parking.repository.CarRepository;
import com.example.parking.repository.PersonRepository;

@RestController
public class PersonController {
    PersonRepository personRepository;
    CarRepository carRepository;

    public PersonController (
        PersonRepository personRepository,
        CarRepository carRepository
    ) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }
    
    @PostMapping("/person")
    public String addPerson(@RequestBody Person person) {
        //Validate person
        personRepository.save(person);
        return "Person saved";
    }

    @GetMapping("/persons")
    public Iterable<Person> getAllPersonNames(){
        return personRepository.findAll();
    }

    @PostMapping("/persons")
    public Person addPerson() {
        Person person = new Person();
        person.setName("Kalle");

        Car car1 = new Car();
        car1.setRegNr("CCC222");
        carRepository.save(car1);

        Car car2 = new Car();
        car2.setRegNr("XYZ889");
        carRepository.save(car2);

        person.getCars().add(car1);
        person.getCars().add(car2);

        personRepository.save(person);
        return personRepository.save(person);

    }
    
}
