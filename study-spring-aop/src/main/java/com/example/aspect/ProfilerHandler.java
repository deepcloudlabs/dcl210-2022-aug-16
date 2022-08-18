package com.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProfilerHandler {

	@Around("execution(* com.example..*(..))")
	public Object profile(ProceedingJoinPoint joinPoint) throws Throwable {
		var methodName = joinPoint.getSignature().getName();
		var start = System.nanoTime();
		var result = joinPoint.proceed();
		var stop = System.nanoTime();
		System.out.println("[ProfilerHandler] %s runs %d ns.".formatted(methodName, (stop - start)));
		return result;
	}

}
