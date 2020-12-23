package me.ianhe.io.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、使用 NIO 完成网络通信的三个核心：
 * <p>
 * 1. 通道（Channel）：负责连接
 * <p>
 * java.nio.channels.Channel 接口：
 * |--SelectableChannel
 * |--SocketChannel
 * |--ServerSocketChannel
 * |--DatagramChannel
 * <p>
 * |--Pipe.SinkChannel
 * |--Pipe.SourceChannel
 * <p>
 * 2. 缓冲区（Buffer）：负责数据的存取
 * <p>
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 *
 * @author iHelin
 * @since 2017/11/22 21:56
 */
public class BlockingNIOTest {

    private final int port = 9898;

    /**
     * 客户端
     *
     * @author iHelin
     * @since 2017/11/22 22:07
     */
    @Test
    public void client() throws IOException {
        //1. 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", port));
        FileChannel inChannel = FileChannel.open(Paths.get("demo/IO.jpg"), StandardOpenOption.READ);
        //2. 分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //3. 读取本地文件，并发送到服务端
        while (inChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //4. 关闭通道
        inChannel.close();
        socketChannel.close();
    }

    /**
     * 服务端
     *
     * @author iHelin
     * @since 2017/11/22 22:07
     */
    @Test
    public void server() throws IOException {
        //1. 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("demo/nio3.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //2. 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(port));
        //3. 获取客户端连接的通道
        SocketChannel socketChannel = serverSocketChannel.accept();
        //4. 分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //5. 接收客户端的数据，并保存到本地
        while (socketChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //6. 关闭通道
        socketChannel.close();
        outChannel.close();
        serverSocketChannel.close();
    }
}
