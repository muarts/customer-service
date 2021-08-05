package com.trendyol.customerservice.service;

import com.trendyol.customerservice.entity.Customer;
import com.trendyol.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException());
    }

    public Customer saveCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    public Customer updateCustomer(Long id, Customer customer) {
        return null;
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}
