package com.mongo.dev.sam.demowithmvn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemowithmvnApplication implements CommandLineRunner {
	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemowithmvnApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();
		// save a couple of cust
		repository.save(new Customer("Sam","Dev"));
		repository.save(new Customer("Bob","Jerry"));
		repository.save(new Customer("Otong","Surotong"));

		// fetch all cust
		System.out.println("Custumer found with findAll() : ");
		System.out.println("--------------------------------");
		for(Customer customer : repository.findAll()){
			System.out.println(customer);
		}
		// enter
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findBYLastName('Dev')");
		System.out.println("--------------------------------");
		System.out.println(repository.findByLastName("Dev"));
		System.out.println();
		System.out.println();

		System.out.println("Customer found with findBYLastName('Jerry')");
		System.out.println("--------------------------------");
		System.out.println(repository.findByLastName("Jerry"));
		System.out.println();
		System.out.println();

		System.out.println("Customer found with findBYLastName('Jerry')");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Otong"));
	}
}
