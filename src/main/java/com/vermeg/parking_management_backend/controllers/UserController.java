package com.vermeg.parking_management_backend.controllers;

import com.vermeg.parking_management_backend.entities.User;
import com.vermeg.parking_management_backend.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@Tag(name = "User Management", description = "Operations related to user management")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{user_id}")
    @Operation(summary = "Get user by ID")
    public ResponseEntity<User> getUserById(
            @Parameter(example = "user123") @PathVariable String user_id) {
        return ResponseEntity.ok(userService.getUserById(user_id));
    }

    @PostMapping
    @Operation(summary = "Create new user")
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        try {
            User createdUser = userService.createUser(newUser);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return ResponseEntity.status(e.getStatusCode())
                    .body(Map.of("error", e.getReason()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(Map.of("error", "Unexpected error occurred"));
        }
    }

    @PutMapping("/{user_id}")
    @Operation(summary = "Update user")
    public ResponseEntity<User> updateUser(
            @Parameter(example = "user123") @PathVariable String user_id,
            @RequestBody User updatedUser) {
        return ResponseEntity.ok(userService.updateUser(user_id, updatedUser));
    }

    @DeleteMapping("/{user_id}")
    @Operation(summary = "Delete user")
    public ResponseEntity<Void> deleteUser(
            @Parameter(example = "user123") @PathVariable String user_id) {
        userService.deleteUser(user_id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetAllUsers() {
        userService.resetAllUsersToFalseAtMidnight();
        return ResponseEntity.ok("All user have been reset to didn't-booked.");
    }
}