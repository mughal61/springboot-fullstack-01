package com.techawarelabs.employeemanager;

import com.techawarelabs.employeemanager.model.Product;
import com.techawarelabs.employeemanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EmployeemanagerApplication implements CommandLineRunner {

	@Autowired
	public ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(EmployeemanagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("Monitor", "Electronics"));
		productRepository.save(new Product( "Blanket", "Household"));
		productRepository.save(new Product("Pens", "School"));
		productRepository.save(new Product("Laptop", "Electronics"));
	}
}
