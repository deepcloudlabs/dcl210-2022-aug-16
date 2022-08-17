package com.example.order.application;

import java.util.ServiceLoader;

import com.example.crm.service.CustomerService;
import com.example.order.dto.OrderRequest;
import com.example.order.service.business.StandrdOrderService;
import com.example.product.service.ProductService;

public class OrderApplication {

	public static void main(String[] args) {
		var orderService = new StandrdOrderService();
		var customerServices = ServiceLoader.load(CustomerService.class);
		var productservice = ServiceLoader.load(ProductService.class).findFirst().get();
		for (var customerService : customerServices) {
			orderService.setCustomerService(customerService);
			orderService.setProductService(productservice);
			var order = orderService.sendOrder(new OrderRequest("11111111110",1L, 10));
			System.out.println(order);			
		}
	}

}
