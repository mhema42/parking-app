package com.example.parking.repository;

import org.springframework.data.repository.ListCrudRepository;

import com.example.parking.entity.ParkingSlot;

public interface ParkingSlotRepository extends ListCrudRepository<ParkingSlot, Long> {

    /* @Query("""
            SELECT p FROM ParkingSlot p WHERE WITHIN(p.coordinate, :geoarea) = true
            """)
    List<ParkingSlot> filterOnArea(@Param("geoarea") Geometry<G2D> geoArea); */

}
