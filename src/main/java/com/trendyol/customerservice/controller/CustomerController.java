package com.trendyol.customerservice.controller;

import com.trendyol.customerservice.entity.Customer;
import com.trendyol.customerservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class CustomerController {

    // Constructor injection as a Spring best practice.
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers/{id}")
    public ResponseEntity<Customer> get(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomer(id));
    }

    @PostMapping(path = "/customers")
    public ResponseEntity<Customer> save(@RequestBody Customer customer){
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(customerService.saveCustomer(customer).getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/customers/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));
    }

    @DeleteMapping(path = "/customers/{id}")
    public void delete(@PathVariable Long id){
        customerService.deleteCustomer(id);
    }

}
