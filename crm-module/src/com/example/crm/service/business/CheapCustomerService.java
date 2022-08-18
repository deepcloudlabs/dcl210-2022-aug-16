package com.example.crm.service.business;

import java.util.Optional;

import com.example.crm.domain.Customer;
import com.example.crm.service.CustomerService;
import com.example.crm.service.Quality;
import com.example.crm.service.QualityLevel;

@Quality(QualityLevel.CHEAP)
public class CheapCustomerService implements CustomerService {
	public CheapCustomerService() {
		System.out.println("CheapCustomerService::FastCustomerService()");
	}

	@Override
	public Optional<Customer> findCustomer(String identity) {
		System.out.println("CheapCustomerService::findCustomer()");
		return Optional.of(new Customer(identity, "jack shephard", "jack@example.com", "+90-555-5555", 1962));
	}

}
