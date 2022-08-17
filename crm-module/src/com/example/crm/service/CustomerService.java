package com.example.crm.service;

import java.util.Optional;

import com.example.crm.domain.Customer;

public interface CustomerService {
	Optional<Customer> findCustomer(String identity);
}
