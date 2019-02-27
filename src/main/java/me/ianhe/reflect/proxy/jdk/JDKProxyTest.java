package me.ianhe.reflect.proxy.jdk;

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

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
//        test();
        test2();
    }

    /**
     * Proxy.getProxyClass
     *
     * @author iHelin
     * @since 2018/2/9 13:56
     */
    public static void test() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
            InstantiationException {
        final Speaker speakerOrigin = new SpeakerImpl();
        Class<?> proxyClass = Proxy.getProxyClass(speakerOrigin.getClass().getClassLoader(), speakerOrigin.getClass().getInterfaces());
        final Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        final InvocationHandler invocationHandler = new SpeakerInvocationHandler(speakerOrigin);
        Speaker speaker = (Speaker) constructor.newInstance(invocationHandler);
        speaker.sayHello();
    }

    /**
     * Proxy.newProxyInstance
     * 这种比较常见
     *
     * @author iHelin
     * @since 2018/2/9 13:56
     */
    public static void test2() {
        final Speaker speakerOri = new SpeakerImpl();
        final InvocationHandler invocationHandler = new SpeakerInvocationHandler(speakerOri);
        Speaker speaker = (Speaker) Proxy.newProxyInstance(Speaker.class.getClassLoader(),
                new Class[]{Speaker.class}, invocationHandler);
        speaker.sayHello();
    }
}
