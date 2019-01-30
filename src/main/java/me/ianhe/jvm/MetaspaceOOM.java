package me.ianhe.jvm;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * 方法区或元空间OOM
 * vm options:
 * java8之前使用：-XX:PermSize和-XX:MaxPermSize来调节
 * java8之后使用：-XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M
 *
 * @author iHelin
 * @since 2018/3/9 16:48
 */
public class MetaspaceOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
//        使用cglib一直不停的创建对象
        long c = 0;
        try {
            while (true) {
                Enhancer eh = new Enhancer();
                eh.setSuperclass(OOMObject.class);
                eh.setUseCache(false);
                eh.setCallback((MethodInterceptor) (arg0, arg1, arg2, arg3) -> arg3.invokeSuper(arg0, arg2));
                eh.create();
                c++;
            }
        } finally {
            System.out.println(c);
        }
    }
}
