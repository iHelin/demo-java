package me.ianhe.netty.aio.fake;

import me.ianhe.netty.bio.TimeServerHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 伪异步io服务端
 *
 * @author iHelin
 * @since 2018/5/15 19:39
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {
        int port = 8080;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("The time server is start in port:" + port);
            Socket socket;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50, 10000);
            while (true) {
                //阻塞等待客户端
                socket = serverSocket.accept();
                singleExecutor.execute(new TimeServerHandler(socket));
            }
        } finally {
            if (serverSocket != null) {
                System.out.println("The time server close");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
