package com.AOP.aspectos.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreeetingServicePointcut {
    @Pointcut("execution(* com.AOP.aspectos.services.GreetingService.*(..))")
    public void greetingLoggerPointcut(){};
}
