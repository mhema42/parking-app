package com.example.parking.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

import com.example.parking.entity.ParkingTime;

@Service
public class ParkingTimeService {

    public static boolean CheckTime(ParkingTime parkingTime) {
        LocalDateTime ParkingEnd = parkingTime.getParkingEnd();
        LocalDateTime now = LocalDateTime.now();
        return ParkingEnd.isBefore(now);
    }
}
