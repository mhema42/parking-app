package com.example.parking.service;

public class CarService {

    public static boolean CheckRegNr(String regNr) {       
        if (regNr.length() != 6) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (Character.isLetter(regNr.charAt(i))) {
                if ((Character.isDigit(regNr.charAt(i + 3)))) {
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
