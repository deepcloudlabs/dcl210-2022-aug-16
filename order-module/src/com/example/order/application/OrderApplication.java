package com.example.order.application;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.crm.service.CustomerService;
import com.example.crm.service.Quality;
import com.example.crm.service.QualityLevel;
import com.example.order.dto.OrderRequest;
import com.example.order.service.business.StandardOrderService;
import com.example.product.service.ProductService;

public class OrderApplication {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.load(new FileInputStream(new File("src","application.properties")));
		var qualityLevel = QualityLevel.valueOf(props.get("customer.service").toString());

		var orderService = new StandardOrderService();
		var customerServices = ServiceLoader.load(CustomerService.class);
		for (var customerService : customerServices) {
			var clazz = customerService.getClass();
			if (clazz.isAnnotationPresent(Quality.class)) {
				var quality = clazz.getAnnotation(Quality.class);
				if (quality.value().equals(qualityLevel)) {
					orderService.setCustomerService(customerService);
					break;
				}
			}
		}		
		var productservice = ServiceLoader.load(ProductService.class).findFirst().get();
		orderService.setProductService(productservice);
		var order = orderService.sendOrder(new OrderRequest("11111111110",1L, 10));
		System.out.println(order);			
	}

}
