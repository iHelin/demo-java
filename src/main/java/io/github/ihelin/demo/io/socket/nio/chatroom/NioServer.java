package io.github.ihelin.demo.io.socket.nio.chatroom;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author iHelin
 * @date 2019-05-06 22:36
 */
public class NioServer {

    private void start() throws IOException {
        //创建Selector
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8000));
        serverSocketChannel.configureBlocking(false);
        //注册
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功");
        for (; ; ) {
            //获取可用Channel数量
            int readyChannels = selector.select();
            if (readyChannels == 0) {
                continue;
            }
            //获取可用Channel的集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                //Selection的实例
                SelectionKey selectionKey = iterator.next();
                //移除Set中的当前selectionKey
                iterator.remove();
                //如果是接入事件
                if (selectionKey.isAcceptable()) {
                    acceptHandler(serverSocketChannel, selector);
                }

                //如果是可读事件
                if (selectionKey.isReadable()) {
                    readHandler(selectionKey, selector);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer();
        nioServer.start();
    }

    /**
     * 接入事件处理器
     */
    private void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        SocketChannel socketChannel = serverSocketChannel.accept();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        socketChannel.write(Charset.forName(StandardCharsets.UTF_8.name()).encode("你与聊天室里的其他人都不是朋友关系，请注意隐私安全"));
    }

    /**
     * 可读事件处理器
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder request = new StringBuilder();
        while (socketChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            request.append(Charset.forName(StandardCharsets.UTF_8.name()).decode(byteBuffer));
        }
        socketChannel.register(selector, SelectionKey.OP_READ);
        if (request.length() > 0) {
            System.out.println("::" + request);
            broadCast(selector, socketChannel, request);
//            socketChannel.write(Charset.forName(StandardCharsets.UTF_8.name()).encode(new Date().toString()));
        }
    }

    private void broadCast(Selector selector, SocketChannel sourceChannel, StringBuilder request) {
        Set<SelectionKey> selectionKeySet = selector.keys();
        selectionKeySet.forEach(selectionKey -> {
            Channel targetChannel = selectionKey.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != sourceChannel) {
                try {
                    //将信息发送到targetChannel客户端
                    ((SocketChannel) targetChannel).write(Charset.forName(StandardCharsets.UTF_8.name()).encode(request.toString()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
