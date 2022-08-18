package com.example.service.business;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.service.Calculator;

@Service
public class StandardCalculator implements Calculator {

	@Override
	@Cacheable(cacheNames = "add")
	public double add(double x, double y) {
		System.err.println("StandardCalculator::add");
		return x + y;
	}

	@Override
	public double sub(double x, double y) {
		return x - y;
	}

	@Override
	public double mul(double x, double y) {
		var sum = 0.0;
		for (var i = 0; i < y; ++i)
			sum = this.add(sum, x);
		return sum;
	}

	@Override
	public double div(double x, double y) {
		return x / y;
	}

}
