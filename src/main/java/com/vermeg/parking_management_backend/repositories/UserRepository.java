package com.vermeg.parking_management_backend.repositories;

import com.vermeg.parking_management_backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Modifying
    @Transactional
    @Query("UPDATE User p SET p.bookedToday = false")
    void resetAllUsersToFalse();
}