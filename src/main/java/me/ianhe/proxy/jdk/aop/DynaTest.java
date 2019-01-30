package me.ianhe.proxy.jdk.aop;

/**
 * @author iHelin
 * @date 2019-01-30 10:47
 */
public class DynaTest {


    public static void main(String[] args) {
        //如果我们需要日志功能，则使用代理类
        IHello hello = (IHello) new DynaProxyHello().bind(new Hello(), new DLogger());
        //IHello hello = new Hello();//如果我们不需要日志功能则使用目标类
        hello.sayHello("明天");
    }

}
