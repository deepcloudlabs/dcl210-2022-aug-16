package com.example.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

public class AuditHandler implements InvocationHandler {
	private final Object target;

	public AuditHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(
				"[AuditHandler] %s runs at %s with parameters [%s].".formatted(method.getName(), new Date(), Arrays.toString(args)));
		var result = method.invoke(target, args);
		System.out.println("[AuditHandler] %s returns %s at [%s].".formatted(method.getName(), result, new Date()));
		return result;
	}

}
