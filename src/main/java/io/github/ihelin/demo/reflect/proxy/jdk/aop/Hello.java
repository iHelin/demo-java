package io.github.ihelin.demo.reflect.proxy.jdk.aop;

/**
 * @author iHelin
 * @since 2019-01-30 10:48
 */
public class Hello implements IHello {

    @Override
    public void sayHello(String str) {
        System.out.println("hello " + str);
    }
}
