package com.example.parking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regNr;

    @ManyToOne
    // @JoinColumn(name = "fk_person")
    @JsonIgnore
    private Person person;
    
    public Car() {

    }

    public Car(String regNr) {
        this.regNr = regNr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {  
        this.id = id;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
