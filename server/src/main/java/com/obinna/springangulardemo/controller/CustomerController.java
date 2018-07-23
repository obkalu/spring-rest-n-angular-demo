package com.obinna.springangulardemo.controller;

import com.obinna.springangulardemo.model.Customer;
import com.obinna.springangulardemo.repository.CustomerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    @GetMapping("primeCustomers")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Map<String, String>> primeCustomers() {
        return customerRepository.findAll().stream()
                .filter(this::isPrimeCustomer)
                .map(c -> {
                    Map<String, String> m = new HashMap<>();
                    m.put("id", c.getId().toString());
                    m.put("name", c.getName());
                    return m;
                }).collect(Collectors.toList());
    }

    private boolean isPrimeCustomer(Customer customer) {
        return !customer.getName().equals("Bob") &&
                !customer.getName().equals("Dave");
    }

}
