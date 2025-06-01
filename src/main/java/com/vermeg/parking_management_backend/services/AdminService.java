package com.vermeg.parking_management_backend.services;

import com.vermeg.parking_management_backend.entities.Administrator;
import com.vermeg.parking_management_backend.repositories.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepo AdminRepo;

    public List<Administrator> getAllAdministrators() {
        return AdminRepo.findAll();
    }

    public Administrator getAdministratorById(String id) {
        Optional<Administrator> Administrator = AdminRepo.findById(id);
        return Administrator.orElse(null);
    }

    public Administrator saveAdministrator(Administrator Administrator) {
        return AdminRepo.save(Administrator);
    }

    public Administrator updateAdministrator(Administrator Administrator) {
        return AdminRepo.save(Administrator);
    }

    public boolean deleteAdministrator(String id) {
        if (AdminRepo.existsById(id)) {
            AdminRepo.deleteById(id);
            return true;
        }
        return false;
    }
}