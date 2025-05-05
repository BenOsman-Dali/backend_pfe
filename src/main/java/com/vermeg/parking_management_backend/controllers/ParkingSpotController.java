package com.vermeg.parking_management_backend.controllers;

import com.vermeg.parking_management_backend.entities.ParkingSpot;
import com.vermeg.parking_management_backend.services.ParkingSpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spots")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    // Constructor-based dependency injection
    @Autowired
    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    /**
     * GET /api/spots - Retrieve all parking spots
     */
    @GetMapping
    public ResponseEntity<List<ParkingSpot>> getAllParkingSpots() {
        List<ParkingSpot> spots = parkingSpotService.getAllParkingSpots();
        return ResponseEntity.ok(spots);
    }

    /**
     * GET /api/spots/{id} - Retrieve a specific parking spot by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ParkingSpot> getParkingSpotById(@PathVariable Long id) {
        ParkingSpot spot = parkingSpotService.getParkingSpotById(id);
        return ResponseEntity.ok(spot);
    }

    /**
     * POST /api/spots - Create a new parking spot
     */
    @PostMapping
    public ResponseEntity<ParkingSpot> createParkingSpot(@RequestBody ParkingSpot parkingSpot) {
        ParkingSpot savedSpot = parkingSpotService.createParkingSpot(parkingSpot);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSpot);
    }

    /**
     * PUT /api/spots/{id} - Update an existing parking spot
     */
    @PutMapping("/{id}")
    public ResponseEntity<ParkingSpot> updateParkingSpot(
            @PathVariable Long id,
            @RequestBody ParkingSpot updatedSpot) {
        ParkingSpot spot = ParkingSpotService.updateParkingSpot(id, updatedSpot);
        return ResponseEntity.ok(spot);
    }

    /**
     * DELETE /api/spots/{id} - Delete a parking spot
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParkingSpot(@PathVariable Long id) {
        ParkingSpotService.deleteParkingSpot(id);
        return ResponseEntity.noContent().build();
    }
}