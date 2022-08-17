package com.example.order.service;

import com.example.order.domain.Order;
import com.example.order.dto.OrderRequest;

public interface OrderService {
	Order sendOrder(OrderRequest request);
}
