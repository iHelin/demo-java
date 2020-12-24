package io.github.ihelin.demo.netty.io.nio;

/**
 * @author iHelin
 * @since 2018/5/15 20:05
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        new Thread(new TimeClientHandler("127.0.0.1", port), "TimeClient-001").start();
    }
}
