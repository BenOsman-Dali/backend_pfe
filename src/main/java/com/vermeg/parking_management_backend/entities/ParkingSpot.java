package com.vermeg.parking_management_backend.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "spots")
public class ParkingSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "department")
    private String department;

    @Column(name = "number")
    private int number;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { this.isAvailable = available; }
}
