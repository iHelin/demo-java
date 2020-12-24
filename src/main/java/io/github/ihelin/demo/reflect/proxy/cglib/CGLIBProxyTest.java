package io.github.ihelin.demo.reflect.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * CGLIB动态代理测试：可直接对类进行代理
 * 示例对HelloConcrete的sayHello方法进行代理测试
 *
 * @author iHelin
 * @since 2018/2/9 14:02
 */
public class CGLIBProxyTest {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HelloConcrete hello = (HelloConcrete) enhancer.create();
        hello.sayHello("Nice to meet you!");
    }
}
