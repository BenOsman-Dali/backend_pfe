package com.vermeg.parking_management_backend.repositories;

import com.vermeg.parking_management_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // No need for custom findById/deleteById methods
}