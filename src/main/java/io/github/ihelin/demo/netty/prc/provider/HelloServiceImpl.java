package io.github.ihelin.demo.netty.prc.provider;

import io.github.ihelin.demo.netty.prc.HelloService;

/**
 * @author iHelin
 * @since 2020/12/29 16:38
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String msg) {
        System.out.println("收到客户端消息：" + msg);
        if (msg != null) {
            return "你好，客户端，我已收到你的消息【" + msg + "]";
        }
        return "你好，客户端，我已收到你的消息";
    }
}
