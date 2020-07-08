package com.fidecoin.billingservice;

import com.fidecoin.billingservice.entities.Bill;
import com.fidecoin.billingservice.entities.Customer;
import com.fidecoin.billingservice.entities.Product;
import com.fidecoin.billingservice.entities.ProductItem;
import com.fidecoin.billingservice.repository.BillRepository;
import com.fidecoin.billingservice.repository.CustomerService;
import com.fidecoin.billingservice.repository.InventoryService;
import com.fidecoin.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
   @Bean
	CommandLineRunner start(BillRepository billRepository,
							ProductItemRepository productItemRepository,
							CustomerService customerService,
							InventoryService inventoryService) {

		Customer c1 = customerService.findCustomerById(1l);



	   System.out.println("************************************************");
	   System.out.println(c1.getId());
	   System.out.println(c1.getName());
	   System.out.println(c1.getEmail());
	   System.out.println("*************************************************");
	   System.out.println("************************************************");

	   System.out.println("*************************************************");
		return  args -> {
			 Bill bill1 = billRepository.save(new Bill(null,new Date(),c1.getId(),null,null));

			PagedModel<Product> allProducts = inventoryService.findAllProducts();
			System.out.println("*************************************************");
			System.out.println(allProducts.getContent());
			System.out.println("************************************************");
			allProducts.getContent().forEach(p-> {
			productItemRepository.save(new ProductItem(null,p.getId(),null,p.getPrice(),34,bill1));

			});
		};

   }
}
