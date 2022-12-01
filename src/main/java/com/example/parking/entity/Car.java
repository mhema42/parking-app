package com.example.parking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Car {

    @Id
    @JoinColumn(name = "carId", referencedColumnName = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String regNr;
    private Long personId; 

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

    public Long getPersonId() {
        return personId;
    }

    public void setPerson_id(Long personId) {
        this.personId = personId;
    }

}
