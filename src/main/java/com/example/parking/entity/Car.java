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
    private Long ID;
    private String regNr;

    @ManyToOne
    //  @JsonIgnore
    private Person person;
    
    public Car() {

    }

    public Car(String regNr) {
        this.regNr = regNr;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long id) {  
        this.ID = id;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }


    // adds person column in car table with null - remove?
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
