package com.vermeg.parking_management_backend.services;

import com.vermeg.parking_management_backend.entities.ParkingSpot;
import com.vermeg.parking_management_backend.repositories.ParkingSpotRepo;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ParkingSpotService {
    private static ParkingSpotRepo parkingSpotRepo;
    public ParkingSpotService(ParkingSpotRepo parkingSpotRepo) {
        this.parkingSpotRepo = parkingSpotRepo;
    }

    public List<ParkingSpot> getAllSpotsSortedById() {
        return parkingSpotRepo.findAllSortedById();
    }

    public ParkingSpot getParkingSpotById(Long spot_id) {
        return parkingSpotRepo.findById(spot_id).orElseThrow(() -> new RuntimeException("ParkingSpot not found with id: " + spot_id));
    }
    public ParkingSpot createParkingSpot(ParkingSpot parkingSpot) { return parkingSpotRepo.save(parkingSpot);}

    public static ParkingSpot updateParkingSpot(Long spot_id, ParkingSpot updatedParkingSpot) {
        Optional<ParkingSpot> optionalParkingSpot = parkingSpotRepo.findById(spot_id);
        if (optionalParkingSpot.isPresent()) {
            ParkingSpot existingParkingSpot = optionalParkingSpot.get();
            existingParkingSpot.setAvailable(updatedParkingSpot.isAvailable());
            return parkingSpotRepo.save(existingParkingSpot);
        }else {
            throw new RuntimeException("ParkingSpot not found with id: " + spot_id);
        }
    }

    public static void deleteParkingSpot(Long spot_id) { parkingSpotRepo.deleteById(spot_id); }
    @Scheduled(cron = "0 0 1 * * ?", zone = "Europe/Paris")// Triggers at 00:00 every day
    @Transactional
    public void resetAllSpotsToAvailableAtMidnight() {
        parkingSpotRepo.resetAllSpotsToAvailable();
    }
}
