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

    // Find by ID
    ParkingSpot findById(long spot_id);

    // Get all spots sorted by ID
    @Query("SELECT s FROM ParkingSpot s ORDER BY s.spot_id ASC")
    List<ParkingSpot> findAllSortedById();

    // Reset all spots to available (true)
    @Modifying
    @Transactional
    @Query("UPDATE ParkingSpot p SET p.isAvailable = true")
    void resetAllSpotsToAvailable();

    // Count booked spots (isAvailable = false)
    @Query("SELECT COUNT(*) FROM ParkingSpot WHERE isAvailable = false")
    int countBookedSpots();

    // Count non-booked (available) spots
    @Query("SELECT COUNT(*) FROM ParkingSpot WHERE isAvailable = true")
    int countNonBookedSpots();// ✔️ Corrected method name casing

    @Query("SELECT COUNT(*) FROM ParkingSpot WHERE department = 'neuchatel'")
    int countNeuchatelSpots();

    @Query("SELECT COUNT(*) FROM ParkingSpot WHERE department = 'constance'")
    int countConstanceSpots();

    @Query("SELECT COUNT(*) FROM ParkingSpot WHERE department = 'biwa'")
    int countBiwaSpots();
}