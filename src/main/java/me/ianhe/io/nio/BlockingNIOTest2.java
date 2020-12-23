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
 * 接收服务端数据
 *
 * @author iHelin
 * @since 2017/11/22 22:09
 */
public class BlockingNIOTest2 {

    private final int port = 9898;

    /**
     * 客户端
     *
     * @author iHelin
     * @since 2017/11/22 22:09
     */
    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", port));
        FileChannel inChannel = FileChannel.open(Paths.get("demo/IO.jpg"), StandardOpenOption.READ);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (inChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        socketChannel.shutdownOutput();
        //接收服务端的反馈
        int length;
        while ((length = socketChannel.read(byteBuffer)) != -1) {
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array(), 0, length));
            byteBuffer.clear();
        }
        inChannel.close();
        socketChannel.close();
    }

    /**
     * 服务端
     *
     * @author iHelin
     * @since 2017/11/22 22:10
     */
    @Test
    public void server() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("demo/nio4.jpg"), StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        serverSocketChannel.bind(new InetSocketAddress(port));
        SocketChannel socketChannel = serverSocketChannel.accept();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (socketChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        //发送反馈给客户端
        byteBuffer.put("服务端接收数据成功".getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        socketChannel.close();
        outChannel.close();
        serverSocketChannel.close();
    }

}
