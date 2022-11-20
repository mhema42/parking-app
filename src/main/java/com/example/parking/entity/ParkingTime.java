package com.example.parking.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingTime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;
    Date date;
    
    public ParkingTime() {

    }

    public ParkingTime(Date date) {
        this.date = date;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
