package com.obinna.springangulardemo;

import com.obinna.springangulardemo.model.Customer;
import com.obinna.springangulardemo.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class CustomerDataPopulationCmdLineRunner implements CommandLineRunner {

    private final CustomerRepository customerRepository;

    public CustomerDataPopulationCmdLineRunner(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Populate the h2 db with a stream of customers
        Stream.of("Ana", "Bob", "Carlos", "Dave", "Eddie")
                .forEach(name -> customerRepository.save(
                        new Customer(name)
        ));

        // To verify db was successfully populated,
        // simply query and print-out the result
        customerRepository.findAll()
                .forEach(System.out::println);
    }
}
