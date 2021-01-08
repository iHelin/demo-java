package io.github.ihelin.demo.spring.aop.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author iHelin
 * @since 2021/1/8 17:57
 */
@Aspect
@Component
public class UserProxy {

    @Before("execution(* io.github.ihelin.demo.spring.aop.config.UserService.add(..))")
    public void before() {
        System.out.println("before...");
    }

    @After("execution(* io.github.ihelin.demo.spring.aop.config.UserService.add(..))")
    public void after() {
        System.out.println("after...");
    }

    @Around("execution(* io.github.ihelin.demo.spring.aop.config.UserService.add(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("around before...");
        Object proceed = point.proceed();
        System.out.println("around after...");
        return proceed;
    }

    @AfterReturning("execution(* io.github.ihelin.demo.spring.aop.config.UserService.add(..))")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    @AfterThrowing("execution(* io.github.ihelin.demo.spring.aop.config.UserService.add(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

}
