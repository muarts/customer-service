package com.trendyol.customerservice;

import com.trendyol.customerservice.entity.Customer;
import com.trendyol.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerService customerService) {
		return args -> {
			Customer customer = new Customer("murat sokucu", "murat.sokucu@gmail.com");
			Customer anotherCustomer = new Customer("ruhat sokucu", "ruhat.sokucu@gmail.com");
			customerService.saveCustomer(customer);
			customerService.saveCustomer(anotherCustomer);
		};
	}

}
