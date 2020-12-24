package io.github.ihelin.demo.reflect.proxy.jdk;

/**
 * 代理对象
 *
 * @author iHelin
 * @since 2017-01-03
 */
public class SpeakerImpl implements Speaker {

    @Override
    public void sayHello() {
        System.out.println("hello world");
    }
}
