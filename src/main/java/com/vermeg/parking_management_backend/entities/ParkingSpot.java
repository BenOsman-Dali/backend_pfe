package com.vermeg.parking_management_backend.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "spots")
public class ParkingSpot {
    @Id
    @Column(name = "spot_id")
    private Long spot_id;

    @Column(name = "department")
    private String department;

    @Column(name = "number")
    private int number;

    @Column(name = "\"isAvailable\"")
    private boolean isAvailable;


    // Getters and setters
    public Long getspot_id() { return spot_id; }
    public void setspot_id(Long spot_id) { this.spot_id = spot_id; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public Boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean isavailable) { this.isAvailable = isavailable; }
}
