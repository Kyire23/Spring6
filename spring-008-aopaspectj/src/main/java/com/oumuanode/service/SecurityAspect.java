package com.oumuanode.service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class SecurityAspect {
    //@Before("execution(* com.oumuanode.service.UserService.*(..))")
    @Before("com.oumuanode.service.LogAspect.tongyongqiedian()")

    public void beforeAdvice(){
        System.out.println("Ç°ÖÃ °²È«..");
    }

}
