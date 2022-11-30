package com.example.parking.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StartParking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private LocalDateTime parkingStart;
    private LocalDateTime parkingEnd;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id", referencedColumnName = "id")
    private ParkingLot parkingLot;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

}
