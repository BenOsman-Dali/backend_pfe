package com.vermeg.parking_management_backend.services;

import com.vermeg.parking_management_backend.entities.Administrator;
import com.vermeg.parking_management_backend.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepo adminRepo;

    @Autowired
    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    public List<Administrator> getAllAdministrators() {
        return adminRepo.findAll();
    }

    public Administrator getAdministratorById(String id) {
        return adminRepo.findById(id).orElse(null);
    }

    public Administrator saveAdministrator(Administrator administrator) {
        return adminRepo.save(administrator);
    }

    public Administrator updateAdministrator(Administrator administrator) {
        return adminRepo.save(administrator);
    }

    public boolean deleteAdministrator(String id) {
        if (adminRepo.existsById(id)) {
            adminRepo.deleteById(id);
            return true;
        }
        return false;
    }
}