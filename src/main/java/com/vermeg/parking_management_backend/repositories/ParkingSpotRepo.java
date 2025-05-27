package com.vermeg.parking_management_backend.repositories;

import com.vermeg.parking_management_backend.entities.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ParkingSpotRepo extends JpaRepository<ParkingSpot, Long> {
    ParkingSpot findById(long spot_id);

    @Query("SELECT s FROM ParkingSpot s ORDER BY s.spot_id ASC")
    List<ParkingSpot> findAllSortedById();
    @Modifying
    @Transactional
    @Query("UPDATE ParkingSpot p SET p.isAvailable = true")
    void resetAllSpotsToAvailable();
}
