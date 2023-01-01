package com.oumuanode.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class LogAspect {
    @Pointcut("execution(* com.oumuanode.service.UserService.*(..))")
    public void tongyongqiedian(){

    }
    //切面 = 通知 + 切点
    //通知 就是具体要编写的增强代码
    //前置通知 （修饰符 返回值类型 权限定类名 方法名(形式参数列表) 异常）
    @Before("tongyongqiedian()")
    public void beforeAdvice(JoinPoint joinPoint)
    {
        //System.out.println("前置通知");
        //获取目标方法的签名
       // Signature signature = joinPoint.getSignature();
        System.out.println("目标方法" +joinPoint.getSignature().getName());

    }

    //后置通知
    @AfterReturning("tongyongqiedian()")
    public void afterReturningAdvice(){
        System.out.println("后置通知");
    }
    //环绕通知
    @Around("tongyongqiedian()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前环绕");
        joinPoint.proceed();//执行目标
        System.out.println("后环绕");
    }
    // 异常通知
    @AfterThrowing("tongyongqiedian()")
    //写在类中

    //最终通知(finally 语句块中的通知 )
    @After("tongyongqiedian()")
    public void afterAdvice(){
        System.out.println("最终通知");
    }


}
