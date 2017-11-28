package me.ianhe.mvc;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

/**
 * 使用nio修改server
 *
 * @author iHelin
 * @create 2017-03-29 22:42
 */
public class NIOServer {

    @Test
    public void client() {
        String msg = "I am client data";
        try {
            Socket socket = new Socket("localhost", 8080);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter.println(msg);
            printWriter.flush();
            String line = is.readLine();
            System.out.println("received from server: " + line);
            printWriter.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void server() throws Exception {
        //创建ServerSocketChannel，监听8080端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //为ssc注册选择器
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //创建处理器
        Handler handler = new Handler(1024);
        while (true) {
            // 等待请求，每次等待阻塞3s，超过3s后线程继续向下运行，如果传入0或者不传参数将一直阻塞
            if (selector.select(3000) == 0) {
                System.out.println("等待请求超时。。。");
                continue;
            }
            System.out.println("处理请求。。。");
            // 获取待处理的SelectionKey
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey key = keyIterator.next();
                try {
                    // 接收到连接请求时
                    if (key.isAcceptable()) {
                        handler.handleAccept(key);
                    }
                    // 读数据
                    if (key.isReadable()) {
                        handler.handleRead(key);
                    }
                } catch (IOException ex) {
                    keyIterator.remove();
                    continue;
                }
                // 处理完后，从待处理的SelectionKey迭代器中移除当前所使用的key
                keyIterator.remove();
            }
        }
    }

    private static class Handler {
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";

        public Handler() {
        }

        public Handler(int bufferSize) {
            this(bufferSize, null);
        }

        public Handler(String LocalCharset) {
            this(-1, LocalCharset);
        }

        public Handler(int bufferSize, String localCharset) {
            if (bufferSize > 0)
                this.bufferSize = bufferSize;
            if (localCharset != null)
                this.localCharset = localCharset;
        }

        public void handleAccept(SelectionKey key) throws IOException {
            SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
            sc.configureBlocking(false);
            sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        public void handleRead(SelectionKey key) throws IOException {
            // 获取channel
            SocketChannel sc = (SocketChannel) key.channel();
            // 获取buffer并重置
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            buffer.clear();
            // 没有读到内容则关闭
            if (sc.read(buffer) == -1) {
                sc.close();
            } else {
                // 将buffer转换为读状态
                buffer.flip();
                // 将buffer中接收到的值按localCharset格式编码后保存到receivedString
                String receivedString = Charset.forName(localCharset).newDecoder().decode(buffer).toString();
                System.out.println("received from client: " + receivedString);

                // 返回数据给客户端
                String sendString = "received data: " + receivedString;
                buffer = ByteBuffer.wrap(sendString.getBytes(localCharset));
                sc.write(buffer);
                // 关闭Socket
                sc.close();
            }
        }
    }

}
