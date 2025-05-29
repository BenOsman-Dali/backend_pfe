package com.vermeg.parking_management_backend.repositories;

import com.vermeg.parking_management_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Count non-booked (available) spots
    @Query("SELECT COUNT(*) FROM User")
    int countUsers();
}