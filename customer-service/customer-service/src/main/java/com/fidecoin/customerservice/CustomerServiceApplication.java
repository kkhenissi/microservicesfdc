package com.fidecoin.customerservice;

import com.fidecoin.customerservice.entities.Customer;
import com.fidecoin.customerservice.repository.projections.CustomerRepositiry;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
    CommandLineRunner start(CustomerRepositiry customerRepositiry) {
		  //
		return  args -> {

		 	customerRepositiry.save(new Customer(null, "khenissi","kkhenissi@gmail.com"));
			customerRepositiry.save(new Customer(null, "eyalena","kkhenissi@gmail.com"));
			customerRepositiry.save(new Customer(null, "lolouche","kkhenissi@gmail.com"));
			customerRepositiry.findAll().forEach(elmt -> {
				System.out.println(elmt);
			});
		};
	}
}
