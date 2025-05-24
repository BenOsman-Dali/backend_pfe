package com.vermeg.parking_management_backend.repositories;

import com.vermeg.parking_management_backend.entities.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingSpotRepo extends JpaRepository<ParkingSpot, Long> {
    ParkingSpot findById(long id);

    long Id(long id);
    @Query("SELECT s FROM ParkingSpot s ORDER BY s.id ASC")
    List<ParkingSpot> findAllSortedById();
}
