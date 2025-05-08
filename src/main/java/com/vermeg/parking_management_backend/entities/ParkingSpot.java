package com.vermeg.parking_management_backend.entities;
import jakarta.persistence.*;

import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "spots")
public class ParkingSpot {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "department")
    private String department;

    @Column(name = "number")
    private int number;

    @Column(name = "isAvailable")
    private Boolean isAvailable;

    // PrePersist callback to generate random ID
    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = ThreadLocalRandom.current().nextLong(1, 10001);
        }
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public Boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean isavailable) { this.isAvailable = isavailable; }
}
