package me.ianhe.proxy.cglib;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

/**
 * CGLIB动态代理测试：可直接对类进行代理
 * 示例对HelloConcrete的sayHello方法进行代理测试
 *
 * @author iHelin
 * @since 2018/2/9 14:02
 */
public class CGLIBProxyTest {

    @Test
    public void test() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloConcrete.class);
        enhancer.setCallback(new MyMethodInterceptor());
        HelloConcrete hello = (HelloConcrete) enhancer.create();
        System.out.println(hello.sayHello("Nice to meet you!"));
    }
}
