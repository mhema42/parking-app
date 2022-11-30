package com.example.parking.service;

import java.time.LocalDateTime;

public class StartParkingService {

    public static boolean CheckTime(LocalDateTime ParkingEnd) {
        return ParkingEnd.isBefore(LocalDateTime.now());
    }
}
