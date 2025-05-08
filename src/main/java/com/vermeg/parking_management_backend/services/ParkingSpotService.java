package com.vermeg.parking_management_backend.services;

import com.vermeg.parking_management_backend.entities.ParkingSpot;
import com.vermeg.parking_management_backend.repositories.ParkingSpotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {
    private static ParkingSpotRepo parkingSpotRepo;
    public ParkingSpotService(ParkingSpotRepo parkingSpotRepo) {
        this.parkingSpotRepo = parkingSpotRepo;
    }

    public List<ParkingSpot> getAllParkingSpots() {
        return parkingSpotRepo.findAll();
    }

    public ParkingSpot getParkingSpotById(Long id) {
        return parkingSpotRepo.findById(id).orElseThrow(() -> new RuntimeException("ParkingSpot not found with id: " + id));
    }
    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) { return parkingSpotRepo.save(parkingSpot);}

    public static ParkingSpot updateParkingSpot(Long id, ParkingSpot updatedParkingSpot) {
        Optional<ParkingSpot> optionalParkingSpot = parkingSpotRepo.findById(id);
        if (optionalParkingSpot.isPresent()) {
            ParkingSpot existingParkingSpot = optionalParkingSpot.get();
            existingParkingSpot.setAvailable(updatedParkingSpot.isAvailable());
            return parkingSpotRepo.save(existingParkingSpot);
        }else {
            throw new RuntimeException("ParkingSpot not found with id: " + id);
        }
    }

    public static void deleteParkingSpot(Long id) { parkingSpotRepo.deleteById(id); }
}
