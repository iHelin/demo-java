package me.ianhe.reflect.proxy.jdk.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author iHelin
 * @date 2019-01-30 10:45
 */
public class DynamicProxyHello<K, T> implements InvocationHandler {

    private K target;

    private T proxy;

    public K bind(K target, T proxy) {
        this.target = target;
        this.proxy = proxy;
        return (K) Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //反射得到操作者的实例
        Class clazz = this.proxy.getClass();
        //反射得到操作者的Start方法
        Method start = clazz.getDeclaredMethod("start", String.class);
        //反射执行start方法
        start.invoke(this.proxy, "你好");
        //执行要处理对象的原本方法
        Object result = method.invoke(this.target, args);
        //反射得到操作者的end方法
        Method end = clazz.getDeclaredMethod("end", String.class);
        //反射执行end方法
        end.invoke(this.proxy, "你好");
        return result;
    }
}
