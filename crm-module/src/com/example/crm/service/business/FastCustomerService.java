package com.example.crm.service.business;

import java.util.Optional;

import com.example.crm.domain.Customer;
import com.example.crm.service.CustomerService;
import com.example.crm.service.Quality;
import com.example.crm.service.QualityLevel;

@Quality(QualityLevel.FAST)
public class FastCustomerService implements CustomerService {
	public FastCustomerService() {
		System.out.println("FastCustomerService::FastCustomerService()");
	}

	@Override
	public Optional<Customer> findCustomer(String identity) {
		System.out.println("FastCustomerService::findCustomer()");
		return Optional.of(new Customer(identity, "jack bauer", "jack@example.com", "+90-555-5555", 1962));
	}

}
