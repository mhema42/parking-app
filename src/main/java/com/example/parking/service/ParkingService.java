package com.example.parking.service;

import java.time.LocalDateTime;

public class ParkingService {

    public static boolean CheckTime(LocalDateTime ParkingEnd) {
        return ParkingEnd.isAfter(LocalDateTime.now());
    }
}
