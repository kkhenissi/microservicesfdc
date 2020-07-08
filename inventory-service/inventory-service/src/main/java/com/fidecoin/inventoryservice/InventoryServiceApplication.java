package com.fidecoin.inventoryservice;

import com.fidecoin.inventoryservice.entities.Product;
import com.fidecoin.inventoryservice.repository.ProductRepository;
import net.minidev.json.JSONUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

    @Bean
	CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
		return  args -> {
			repositoryRestConfiguration.exposeIdsFor(Product.class);
			productRepository.save(new Product(null, "bookAnalyser", 1230));
			productRepository.save(new Product(null, "radiofrequency", 1230));
			productRepository.save(new Product(null, "managerfutear", 1230));
			productRepository.findAll().forEach(elmt -> {
				System.out.println(elmt);
			});

		};

	}
}
