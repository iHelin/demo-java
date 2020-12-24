package io.github.ihelin.demo.netty.io.nio;

import java.io.IOException;

/**
 * 伪异步io服务端
 *
 * @author iHelin
 * @since 2018/5/15 19:39
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
