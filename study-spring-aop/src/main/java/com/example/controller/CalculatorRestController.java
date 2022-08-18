package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.dto.CalculatorRequest;
import com.example.dto.CalculatorResponse;
import com.example.service.Calculator;

@RestController
@RequestScope
@RequestMapping("calculate")
public class CalculatorRestController {
	private final Calculator calculator;
	
	public CalculatorRestController(Calculator calculator) {
		this.calculator = calculator;
	}

	@PostMapping
	public CalculatorResponse calculate(@RequestBody CalculatorRequest request) {
		return new CalculatorResponse( switch (request.getOperation()) {
			case ADD -> {
				yield calculator.add(request.getX(), request.getY());
			}
			case SUB -> {
				yield calculator.sub(request.getX(), request.getY());
			}
			case MUL -> {
				yield calculator.mul(request.getX(), request.getY());
			}
			case DIV -> {
				yield calculator.div(request.getX(), request.getY());
			}
			default -> {
				throw new IllegalArgumentException("Unexpected value: " + request.getOperation());			
			}
		});
	}
}
