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
    private Long ID;
    private LocalDateTime parkingStart;
    private LocalDateTime parkingEnd;

    public Long getID() {
        return ID;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public LocalDateTime getParkingStart() {
        return parkingStart;
    }

    public void setParkingStart(LocalDateTime parkingStart) {
        this.parkingStart = parkingStart;
    }

    public LocalDateTime getParkingEnd() {
        return parkingEnd;
    }

    public void setParkingEnd(LocalDateTime parkingEnd) {
        this.parkingEnd = parkingEnd;
    }

}
