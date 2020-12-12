package org.sid.customerService;

import org.sid.customerService.entities.Customer;
import org.sid.customerService.repository.CustomerRepository;
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
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
		return args -> {
			restConfiguration.exposeIdsFor(Customer.class);
			customerRepository.save(new Customer(null, "Mohammed", "mohammed@gmail.com"));
			customerRepository.save(new Customer(null, "Amine", "amine@gmail.com"));
			customerRepository.save(new Customer(null, "Adam", "adam@gmail.com"));
			customerRepository.findAll().forEach(c -> {
				System.out.println(c);
			});
		};
	}

}
