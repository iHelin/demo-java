package me.ianhe.other.netty.io.aio;

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
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(port);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
}
