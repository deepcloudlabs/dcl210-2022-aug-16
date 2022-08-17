package com.example.order.service.business;

import java.util.UUID;

import com.example.crm.service.CustomerService;
import com.example.order.domain.Order;
import com.example.order.dto.OrderRequest;
import com.example.order.service.OrderService;
import com.example.product.service.ProductService;

public class StandardOrderService implements OrderService {
	// dependency
	private CustomerService customerService;
	private ProductService productService;

	// dependency injection: setter injection
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public Order sendOrder(OrderRequest request) {
		System.out.println(productService.getClass());
		System.out.println(customerService.getClass());
		var identity = request.identity();
		var productId = request.productId();
		var customer = customerService.findCustomer(identity)
				                      .orElseThrow(() -> new IllegalArgumentException("Cannot find customer.")); 
		var product = productService.findProduct(productId)
				                    .orElseThrow(() -> new IllegalArgumentException("Cannot find product.")); 
		return new Order(
				UUID.randomUUID().toString(), 
				product, 
				customer, 
				request.quantity(), 
				request.quantity() * product.price()
			  );
	}

}
