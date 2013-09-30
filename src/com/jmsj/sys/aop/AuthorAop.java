package com.jmsj.sys.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
@Service("authorAop")
public class AuthorAop {

	@Before("execution(* com.jmsj..controller..*.*(..))")
	public void author(JoinPoint jp){
		System.out.println("className:"+jp.getTarget().getClass().getName());
		System.out.println("methodName:" + jp.getSignature().getName());
	}
}
