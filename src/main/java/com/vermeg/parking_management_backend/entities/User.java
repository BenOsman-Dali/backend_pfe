package com.vermeg.parking_management_backend.entities;

import jakarta.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "phone_number", length = 255)
    private String phoneNumber;

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

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}