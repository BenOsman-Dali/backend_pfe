package com.vermeg.parking_management_backend.services;

import com.vermeg.parking_management_backend.entities.User;
import com.vermeg.parking_management_backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User createUser(User newUser) {
        try {
            // Validate required fields
            if (!StringUtils.hasText(newUser.getId())) {
                throw new IllegalArgumentException("User ID is required");
            }
            if (userRepository.existsById(newUser.getId())) {
                throw new IllegalArgumentException("User ID already exists");
            }
            if (!StringUtils.hasText(newUser.getEmail())) {
                throw new IllegalArgumentException("Email is required");
            }

            return userRepository.save(newUser);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Failed to create user: " + e.getMessage()
            );
        }
    }

    public User updateUser(String id, User updatedUser) {
        User existingUser = getUserById(id); // Will throw if not found
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
        return userRepository.save(existingUser);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}