package com.example.order.domain;

import com.example.crm.domain.Customer;
import com.example.product.domain.Product;

public record Order(String orderId, Product product, Customer customer, int quantity, double totalPrice) {
}
