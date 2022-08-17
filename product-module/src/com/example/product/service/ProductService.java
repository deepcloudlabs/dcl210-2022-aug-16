package com.example.product.service;

import java.util.Optional;

import com.example.product.domain.Product;

public interface ProductService {
	Optional<Product> findProduct(long productId);
}
