package io.github.ihelin.demo.spring.aop.xml;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author iHelin
 * @since 2017-04-15 20:55
 */
public class GreetingAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("after.......Please enjoy yourself!");
    }
}
