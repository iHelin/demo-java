package me.ianhe.reflect.proxy.jdk.aop;

/**
 * @author iHelin
 * @date 2019-01-30 10:47
 */
public class DynaTest {

    public static void main(String[] args) {
        //如果我们需要日志功能，则使用代理类
        IHello hello = new DynamicProxyHello<IHello, ILogger>().bind(new Hello(), new DLogger());
        hello.sayHello("world");
    }

}
