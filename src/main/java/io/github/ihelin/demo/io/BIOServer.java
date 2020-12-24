package io.github.ihelin.demo.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        //创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了。。。");

        while (true) {
            //阻塞监听，等待客户端连接
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            threadPool.execute(() -> handle(socket));
        }
    }


    /**
     * 处理客户端通信
     *
     * @param socket
     */
    private static void handle(Socket socket) {
        try (InputStream inputStream = socket.getInputStream()) {
            System.out.println("线程id:" + Thread.currentThread().getId());

            byte[] bytes = new byte[1024];
            int readLength;
            while ((readLength = inputStream.read(bytes)) != -1) {
                System.out.println(new String(bytes, 0, readLength));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
