package com.example.crm.service.business;

import java.util.Optional;

import com.example.crm.domain.Customer;
import com.example.crm.service.CustomerService;

public class FastCustomerService implements CustomerService {
	public FastCustomerService() {
		System.out.println("FastCustomerService::FastCustomerService()");
	}

	@Override
	public Optional<Customer> findCustomer(String identity) {
		return Optional.of(new Customer(identity, "jack bauer", "jack@example.com", "+90-555-5555", 1962));
	}

}
