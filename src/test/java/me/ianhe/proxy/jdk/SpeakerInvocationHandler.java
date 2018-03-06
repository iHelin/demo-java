package me.ianhe.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Speaker代理类
 *
 * @author iHelin
 * @since 2017-01-03 16:39
 */
public class SpeakerInvocationHandler implements InvocationHandler {

    private Speaker target;

    public SpeakerInvocationHandler(Speaker target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before:" + method.getName() + "() will be invoked!");
        Object res = method.invoke(target, args);
        System.out.println("After...");
        return res;
    }
}