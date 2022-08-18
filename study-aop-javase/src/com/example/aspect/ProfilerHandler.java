package com.example.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfilerHandler implements InvocationHandler {
	private final Object target;

	public ProfilerHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var start = System.nanoTime();
		var result = method.invoke(target, args);
		var stop = System.nanoTime();
		System.out.println("[ProfilerHandler] %s runs %d ns.".formatted(method.getName(), (stop-start)));
		return result;
	}

}
