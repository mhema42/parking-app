package com.example.parking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ParkingTime {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ID;
    LocalDateTime timestamp;
    
    public ParkingTime() {

    }

    //  ** Pre-req sqript in postman below **
    //      var timestamp = new Date();
    //      postman.setEnvironmentVariable("timestamp", timestamp.toISOString());
    //  ** Send **
    //      "timestamp": "{{timestamp}}" 
    //  ** as json in body **

    public ParkingTime(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
}
