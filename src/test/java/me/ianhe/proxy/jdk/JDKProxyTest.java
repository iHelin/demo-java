package me.ianhe.proxy.jdk;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理测试：只能对接口代理
 *
 * @author iHelin
 * @since 2017-01-03 16:35
 */
public class JDKProxyTest {

    /**
     * Proxy.getProxyClass
     *
     * @author iHelin
     * @since 2018/2/9 13:56
     */
    @Test
    public void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {
        Class<?> proxyClass = Proxy.getProxyClass(JDKProxyTest.class.getClassLoader(), Speaker.class);
        final Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        final InvocationHandler invocationHandler = new SpeakerInvocationHandler(new SpeakerImpl());
        Speaker speaker = (Speaker) constructor.newInstance(invocationHandler);
        speaker.sayHello();

    }

    /**
     * Proxy.newProxyInstance
     *
     * @author iHelin
     * @since 2018/2/9 13:56
     */
    @Test
    public void test2() {
        final InvocationHandler invocationHandler = new SpeakerInvocationHandler(new SpeakerImpl());
        Speaker speaker = (Speaker) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{Speaker.class}, invocationHandler);
        speaker.sayHello();
    }
}
