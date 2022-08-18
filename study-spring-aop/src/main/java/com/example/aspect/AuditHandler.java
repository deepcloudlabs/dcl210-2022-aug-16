package com.example.aspect;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuditHandler  {

	@Around("execution(* com.example.service..*(..))")
	public Object audit(ProceedingJoinPoint joinPoint) throws Throwable {
		var methodNme = joinPoint.getSignature().getName();
		System.out.println(
				"[AuditHandler] %s runs at %s with parameters [%s].".formatted(methodNme, 
						new Date(), Arrays.toString(joinPoint.getArgs())));
		var result = joinPoint.proceed();
		System.out.println("[AuditHandler] %s returns %s at [%s].".formatted(methodNme, result, new Date()));
		return result;
	}

}
