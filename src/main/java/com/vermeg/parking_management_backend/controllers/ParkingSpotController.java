package com.vermeg.parking_management_backend.controllers;

import com.vermeg.parking_management_backend.entities.ParkingSpot;
import com.vermeg.parking_management_backend.services.ParkingSpotService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spots")
@Tag(name = "Parking Spot Management", description = "Operations related to parking spots")
@CrossOrigin("*")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    @Autowired
    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @GetMapping
    @Operation(summary = "Get all parking spots", description = "Retrieves a list of all parking spots")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved parking spots")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ResponseEntity<List<ParkingSpot>> getAllParkingSpots() {
        List<ParkingSpot> spots = parkingSpotService.getAllSpotsSortedById();
        return ResponseEntity.ok(spots);
    }

    @GetMapping("/{spot_id}")
    @Operation(summary = "Get parking spot by ID", description = "Retrieves a specific parking spot by its ID")
    @ApiResponse(responseCode = "200", description = "Parking spot found")
    @ApiResponse(responseCode = "404", description = "Parking spot not found")
    public ResponseEntity<ParkingSpot> getParkingSpotById(
            @Parameter(description = "ID of the parking spot to be retrieved", example = "1")
            @PathVariable Long spot_id) {
        ParkingSpot spot = parkingSpotService.getParkingSpotById(spot_id);
        return ResponseEntity.ok(spot);
    }

    @PostMapping
    @Operation(summary = "Create new parking spot", description = "Creates a new parking spot entry")
    @ApiResponse(responseCode = "201", description = "Parking spot created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public ResponseEntity<ParkingSpot> createParkingSpot(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Parking spot object to be created",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ParkingSpot.class),
                            examples = @ExampleObject(
                                    value = "{\"isAvailable\":\"true\"}"
                            )
                    )
            )
            @RequestBody ParkingSpot parkingSpot) {
        ParkingSpot savedSpot = parkingSpotService.createParkingSpot(parkingSpot);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSpot);
    }

    @PutMapping("/{spot_id}")
    @Operation(summary = "Update parking spot", description = "Updates an existing parking spot's information")
    @ApiResponse(responseCode = "200", description = "Parking spot updated successfully")
    @ApiResponse(responseCode = "404", description = "Parking spot not found")
    public ResponseEntity<ParkingSpot> updateParkingSpot(
            @Parameter(description = "ID of the parking spot to be updated", example = "1")
            @PathVariable Long spot_id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Updated parking spot object",
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ParkingSpot.class)
                    )
            )
            @RequestBody ParkingSpot updatedSpot) {
        ParkingSpot spot = parkingSpotService.updateParkingSpot(spot_id, updatedSpot);
        return ResponseEntity.ok(spot);
    }

    @DeleteMapping("/{spot_id}")
    @Operation(summary = "Delete parking spot", description = "Deletes a parking spot by its ID")
    @ApiResponse(responseCode = "204", description = "Parking spot deleted successfully")
    @ApiResponse(responseCode = "404", description = "Parking spot not found")
    public ResponseEntity<Void> deleteParkingSpot(
            @Parameter(description = "ID of the parking spot to be deleted", example = "1")
            @PathVariable Long spot_id) {
        parkingSpotService.deleteParkingSpot(spot_id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/reset")
    public ResponseEntity<String> resetAllSpots() {
        parkingSpotService.resetAllSpotsToAvailableAtMidnight();
        return ResponseEntity.ok("All spots have been reset to available.");
    }
}