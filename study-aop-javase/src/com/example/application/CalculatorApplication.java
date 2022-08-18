package com.example.application;

import java.lang.reflect.Proxy;

import com.example.aspect.AuditHandler;
import com.example.aspect.ProfilerHandler;
import com.example.service.Calculator;
import com.example.service.business.StandardCalculator;

public class CalculatorApplication {

	public static void main(String[] args) {
		var stdCalculator = new StandardCalculator();
		var clazz = stdCalculator.getClass();
		var clazzLoader = clazz.getClassLoader();
		var proxyCalculator = (Calculator)
				Proxy.newProxyInstance(clazzLoader, clazz.getInterfaces(), new AuditHandler(stdCalculator));
		proxyCalculator = (Calculator)
				Proxy.newProxyInstance(clazzLoader, clazz.getInterfaces(), new ProfilerHandler(proxyCalculator));
		stdCalculator.setSelf(proxyCalculator);
		System.out.println("3 + 5 = %f.".formatted(proxyCalculator.add(3, 5)));
		System.out.println("3 - 5 = %f.".formatted(proxyCalculator.sub(3, 5)));
		System.out.println("3 * 5 = %f.".formatted(proxyCalculator.mul(3, 5)));
		System.out.println("3 / 5 = %f.".formatted(proxyCalculator.div(3, 5)));

	}

}
