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
    //���� = ֪ͨ + �е�
    //֪ͨ ���Ǿ���Ҫ��д����ǿ����
    //ǰ��֪ͨ �����η� ����ֵ���� Ȩ�޶����� ������(��ʽ�����б�) �쳣��
    @Before("tongyongqiedian()")
    public void beforeAdvice(JoinPoint joinPoint)
    {
        //System.out.println("ǰ��֪ͨ");
        //��ȡĿ�귽����ǩ��
       // Signature signature = joinPoint.getSignature();
        System.out.println("Ŀ�귽��" +joinPoint.getSignature().getName());

    }

    //����֪ͨ
    @AfterReturning("tongyongqiedian()")
    public void afterReturningAdvice(){
        System.out.println("����֪ͨ");
    }
    //����֪ͨ
    @Around("tongyongqiedian()")
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("ǰ����");
        joinPoint.proceed();//ִ��Ŀ��
        System.out.println("����");
    }
    // �쳣֪ͨ
    @AfterThrowing("tongyongqiedian()")
    //д������

    //����֪ͨ(finally �����е�֪ͨ )
    @After("tongyongqiedian()")
    public void afterAdvice(){
        System.out.println("����֪ͨ");
    }


}
