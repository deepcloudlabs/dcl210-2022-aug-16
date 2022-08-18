package com.example.crm.service.business;

import java.util.Optional;

import com.example.crm.domain.Customer;
import com.example.crm.service.CustomerService;
import com.example.crm.service.Quality;
import com.example.crm.service.QualityLevel;

@Quality(QualityLevel.STANDARD)
public class StandardCustomerService implements CustomerService {
	public StandardCustomerService() {
		System.out.println("StandardCustomerService::StandardCustomerService()");
	}

	@Override
	public Optional<Customer> findCustomer(String identity) {
		System.out.println("StandardCustomerService::findCustomer()");
		return Optional.of(new Customer(identity, "jack bauer", "jack@example.com", "+90-555-5555", 1962));
	}

}
