package com.vermeg.parking_management_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EntityScan(basePackages = "com.vermeg.parking_management_backend.entities")  // Force entity scan
@EnableJpaRepositories(basePackages = "com.vermeg.parking_management_backend.repositories")  // Force repository scan
public class ParkingManagementBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingManagementBackendApplication.class, args);
	}

}
