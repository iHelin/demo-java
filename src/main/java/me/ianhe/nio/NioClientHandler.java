package me.ianhe.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author iHelin
 * @date 2019-05-06 23:10
 */
public class NioClientHandler implements Runnable {

    private Selector selector;

    public NioClientHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
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

                    //如果是可读事件
                    if (selectionKey.isReadable()) {
                        readHandler(selectionKey, selector);
                    }
                }
            }
        } catch (Exception e) {

        }
    }

    /**
     * 可读事件处理器
     */
    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder response = new StringBuilder();
        while (socketChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            response.append(Charset.forName(StandardCharsets.UTF_8.name()).decode(byteBuffer));
        }
        socketChannel.register(selector, SelectionKey.OP_READ);
        if (response.length() > 0) {
            System.out.println(response);
        }
    }
}
