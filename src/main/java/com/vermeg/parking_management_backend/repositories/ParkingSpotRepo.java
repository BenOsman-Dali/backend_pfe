package com.vermeg.parking_management_backend.repositories;

import com.vermeg.parking_management_backend.entities.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepo extends JpaRepository<ParkingSpot, Long> {
    ParkingSpot findById(long id);

    long Id(long id);
}
