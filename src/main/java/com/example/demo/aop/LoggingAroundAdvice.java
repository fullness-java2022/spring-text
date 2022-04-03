package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAroundAdvice {
	@Around("execution(* com.example.demo.di.*.*(..))")
	public Object arroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("実行前");
		Object result = joinPoint.proceed();
		System.out.println("実行結果:"+result.toString());
		return result;
	}
}
