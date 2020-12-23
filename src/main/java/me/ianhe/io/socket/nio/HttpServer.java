package me.ianhe.io.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

/**
 * http server 实例
 * 《看透spring mvc》
 *
 * @author iHelin
 * @since 2017-04-02 16:47
 */
public class HttpServer {

    public static void main(String[] args) throws Exception {
        //创建ServerSocketChannel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //监听8080端口
        serverSocketChannel.socket().bind(new InetSocketAddress(8000));
        //设置为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //创建选择器
        Selector selector = Selector.open();
        //为serverSocketChannel注册选择器
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //创建处理器
        while (true) {
            // 等待请求，每次等待阻塞3s，超过3s后线程继续向下运行，如果传入0或者不传参数将一直阻塞
            if (selector.select(3000) == 0) {
                continue;
            }
            // 获取待处理的SelectionKey
            Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();

            while (keyIterator.hasNext()) {
                SelectionKey selectionKey = keyIterator.next();
                // 启动新线程处理SelectionKey
                Thread thread = new Thread(new HttpHandler(selectionKey), "http-thread");
                thread.run();
                // 处理完后，从待处理的SelectionKey迭代器中移除当前所使用的key
                keyIterator.remove();
            }
        }
    }

    private static class HttpHandler implements Runnable {
        private final SelectionKey selectionKey;

        public HttpHandler(SelectionKey selectionKey) {
            this.selectionKey = selectionKey;
        }

        @Override
        public void run() {
            try {
                // 接收到连接请求时
                if (selectionKey.isAcceptable()) {
                    handleAccept();
                }
                // 读数据
                if (selectionKey.isReadable()) {
                    handleRead();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        private void handleAccept() throws IOException {
            int bufferSize = 1024;
            SocketChannel clientChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
            clientChannel.configureBlocking(false);
            clientChannel.register(selectionKey.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }

        private void handleRead() throws IOException {
            // 获取channel
            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
            // 获取buffer并重置
            ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
            byteBuffer.clear();
            // 没有读到内容则关闭
            if (socketChannel.read(byteBuffer) == -1) {
                socketChannel.close();
            } else {
                // 接收请求数据
                byteBuffer.flip();
                String receivedString = StandardCharsets.UTF_8.decode(byteBuffer).toString();

                // 控制台打印请求报文头
                String[] requestMessage = receivedString.split("\r\n");
                for (String s : requestMessage) {
                    System.out.println(s);
                    // 遇到空行说明报文头已经打印完
                    if (s.isEmpty()) {
                        break;
                    }
                }

                // 控制台打印首行信息
                String[] firstLine = requestMessage[0].split(" ");
                System.out.println();
                System.out.println("Method:\t" + firstLine[0]);
                System.out.println("url:\t" + firstLine[1]);
                System.out.println("HTTP Version:\t" + firstLine[2]);
                System.out.println();

                // 返回客户端
                StringBuilder sendString = new StringBuilder();
                //响应报文首行，200表示处理成功
                sendString.append("HTTP/1.1 200 OK\r\n");
                sendString.append("Content-Type:text/html;charset=UTF-8\r\n");
                // 报文头结束后加一个空行
                sendString.append("\r\n");

                sendString.append("<html><head><title>OK</title></head><body>");
                sendString.append("接收到的请求报文是：<br/>");
                for (String s : requestMessage) {
                    sendString.append(s).append("<br/>");
                }
                sendString.append("</body></html>");
                byteBuffer = ByteBuffer.wrap(sendString.toString().getBytes(StandardCharsets.UTF_8));
                socketChannel.write(byteBuffer);
                socketChannel.close();
            }
        }

    }

}
