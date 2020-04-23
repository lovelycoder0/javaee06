package com.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
/*
Aspect
joinpoint
Advice
Pointcut

using:xml、@Aspectj配置*/


@Aspect
@Component
public class TestAspect {

    @Pointcut("execution(* com.spring.service.*.*(..))")
    public void service(){}

    //Advice
    @Before("service()")
    public void beforeService(){
        System.out.println("Before Service.");
    }

    @After("service()")
    public void afterService(){
        System.out.println("After Service.");
    }

    @Around("service()")
    public Object aroundSerive(ProceedingJoinPoint jp){
        Object object=null;
        try{
            System.out.println("Before Around Service.");
            //JoinPoint
            object=jp.proceed();

            //日志输出，请求参数、响应参数的记录
            System.out.println("After Around Service."+object);
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return object;
    }
}
