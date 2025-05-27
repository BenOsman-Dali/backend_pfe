package com.vermeg.parking_management_backend.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id", length = 255)
    private String user_id;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "phone_number", length = 255)
    private String phoneNumber;

    @Column(name = "booked_today", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private boolean bookedToday;

    // Foreign key
    @ManyToOne
    @JoinColumn(
            name = "spot_id",              // Column in 'users' table
            referencedColumnName = "spot_id" // Column in 'spots' table
    )
    private ParkingSpot parkingSpot;
    
    // Getters and setters
    public String getuser_id() { return user_id; }
    public void setuser_id(String user_id) { this.user_id = user_id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Boolean getBookedToday() {return bookedToday;}
    public void setBookedToday(Boolean bookedToday) {
        if (bookedToday == null) {
            this.bookedToday = false;
            this.parkingSpot = null;
        } else {
            this.bookedToday = bookedToday;
            if (!bookedToday) {
                this.parkingSpot = null; // Clear spot if not booked
            }
        }
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
        if (parkingSpot != null) {
            this.bookedToday = true; // Auto-set bookedToday to true
        }
    }
}