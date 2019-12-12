package com.lemon.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RetryAop {

	@Around(value = "execution(* com.lemon.service.impl.*.*(..))")
	public Object retry(ProceedingJoinPoint joinpoint) throws Throwable {

        Object result = null;
		try {
            result = joinpoint.proceed();
		}catch (Exception ex){
            System.out.println("aop catch "+ ex.getMessage()+"--------------------->>"+joinpoint.getArgs()[0]+"失败插入db>>============");
		}
        return result;
	}

}
