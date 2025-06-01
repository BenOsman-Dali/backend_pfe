package com.vermeg.parking_management_backend.controllers;

import com.vermeg.parking_management_backend.entities.Administrator;
import com.vermeg.parking_management_backend.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Administrators")
public class AdminController {

    @Autowired
    private AdminService AdminService;

    @GetMapping
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        List<Administrator> Administrators = AdminService.getAllAdministrators();
        return new ResponseEntity<>(Administrators, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable String id) {
        Administrator Administrator = AdminService.getAdministratorById(id);
        return Administrator != null ? new ResponseEntity<>(Administrator, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator Administrator) {
        Administrator savedAdministrator = AdminService.saveAdministrator(Administrator);
        return new ResponseEntity<>(savedAdministrator, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable String id, @RequestBody Administrator Administrator) {
        Administrator.setAdmin_id(id);
        Administrator updatedAdministrator = AdminService.updateAdministrator(Administrator);
        return ResponseEntity.ok(updatedAdministrator); // Make sure this is not null
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable String id) {
        boolean deleted = AdminService.deleteAdministrator(id);
        return deleted ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}