package com.example.crm.service.business;

import java.util.Optional;

import com.example.crm.domain.Customer;
import com.example.crm.service.CustomerService;

public class StandardCustomerService implements CustomerService {
	public StandardCustomerService() {
		System.out.println("StandardCustomerService::StandardCustomerService()");
	}

	@Override
	public Optional<Customer> findCustomer(String identity) {
		return Optional.of(new Customer(identity, "jack bauer", "jack@example.com", "+90-555-5555", 1962));
	}

}
