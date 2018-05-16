package me.ianhe.netty.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
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
            while (true) {
                //阻塞等待客户端
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
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
