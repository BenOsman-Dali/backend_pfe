package com.vermeg.parking_management_backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // Explicitly maps to the "id" column
    private Long id;

    @Column(name = "first_name", length = 255) // Maps to first_name
    private String firstName;

    @Column(name = "last_name", length = 255) // Maps to last_name
    private String lastName;

    @Column(name = "email", length = 255) // Maps to email
    private String email;

    @Column(name = "phone_number", length = 255) // Maps to phone_number
    private String phoneNumber;

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