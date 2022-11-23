package com.example.parking.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.parking.entity.ParkingLot;

public interface ParkingLotRepository extends ListCrudRepository<ParkingLot, Long> {

    /* @Query("""
            SELECT p FROM ParkingLot p WHERE WITHIN(p.coordinate, :geoarea) = true
            """)
    List<ParkingLot> filterOnArea(@Param("geoarea") Geometry<G2D> geoArea); */

}
