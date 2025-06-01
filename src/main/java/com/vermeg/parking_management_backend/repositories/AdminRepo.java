package com.vermeg.parking_management_backend.repositories;

import com.vermeg.parking_management_backend.entities.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdminRepo extends JpaRepository<Administrator, String> {
    Optional<Administrator> findByEmail(String email);
    boolean existsByEmail(String email);
}