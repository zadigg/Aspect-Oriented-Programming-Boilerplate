package com.example.aop.aspect;


import com.example.aop.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class GeneralInterceptorAspect {
    // JoinPoints: a specific point in the code
    // Pointcut: collection of join points
    @Pointcut("execution(* com.example.aop.service.*.*(..))")
    public void forServicePackage() {}


    @Before("forServicePackage()")
    public void before (JoinPoint joinPoint) {
        log.info("Before method invoked::"+joinPoint.getSignature());
    }

    @After("forServicePackage()")
    public void after (JoinPoint joinPoint) {
        log.info("After method invoked::"+joinPoint.getSignature());
    }

    @AfterReturning(value = "forServicePackage()", returning = "number")
    public void afterReturning (JoinPoint joinPoint, int number) {
        log.info("After Returning method invoked::"+ number);
    }

    @AfterThrowing(value = "execution(* com.example.aop.service.AccountService.updateAccount(..))", throwing = "exception")
    public void after (JoinPoint joinPoint, Exception exception) {
        log.info("AfterThrowing method invoked::"+ exception);
    }

    @Around("forServicePackage()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("This is Before around::"+joinPoint.getSignature());
        Object object = joinPoint.proceed();
        log.info("This is After around::"+joinPoint.getSignature());
        return object;
    }


}
