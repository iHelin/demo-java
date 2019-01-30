package me.ianhe.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author iHelin
 * @since 2018/2/9 14:00
 */
public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Before...");
        Object res = methodProxy.invokeSuper(obj, args);
        System.out.println("After...");
        return res;
    }
}
