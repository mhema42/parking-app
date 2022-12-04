package com.example.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.parking.entity.Parking;

public interface ParkingRepository extends ListCrudRepository<Parking, Long> {

    @Query("""  
            SELECT p FROM Parking p WHERE p.status = :status
                    """)
    List<Parking> findByStatus(@Param("status") String status);

    @Query("""  
            SELECT p FROM Parking p WHERE p.person.id = :id
                    """)
    List<Parking> findByPersonId(@Param("id") Long id);

    @Query("""  
            SELECT p FROM Parking p WHERE p.car.id = :id
                    """)
    List<Parking> findByCarId(@Param("id") Long id);

}