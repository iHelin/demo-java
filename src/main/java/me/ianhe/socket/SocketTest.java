package me.ianhe.socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * SocketTest
 *
 * @author iHelin
 * @since 2017/11/29 11:03
 */
public class SocketTest {

    /**
     * 服务端
     *
     * @author iHelin
     * @since 2017/11/29 11:07
     */
    @Test
    public void service() {
        System.out.println("等待客户端连接中...");
        try (ServerSocket serversocket = new ServerSocket(8888);
             //阻塞等待。。。
             Socket socket = serversocket.accept();
             InputStream inputStream = socket.getInputStream();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String info;
            while ((info = bufferedReader.readLine()) != null) {
                System.out.println(info);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 客户端
     *
     * @author iHelin
     * @since 2017/11/29 11:07
     */
    @Test
    public void client() {
        try (Socket socket = new Socket("127.0.0.1", 8888);
             OutputStream outputStream = socket.getOutputStream();
             PrintWriter printWriter = new PrintWriter(outputStream)) {
            printWriter.print("Hello");
            printWriter.flush();
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
