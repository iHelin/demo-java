package io.github.ihelin.demo.io.nio;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 一、通道(channel):用于源节点与目标节点的连接。
 * 在javaNIO中负责缓冲区中数据的传输。channel本身不存储数据，因此需要配合缓冲区进行传输。
 * <p>
 * 二、通道的一些主要实现类：
 * java.nio.channels.{@link java.nio.channels.Channel}接口：
 * FileChannel
 * SocketChannel
 * ServerSocketChannel
 * DatagramChannel
 * <p>
 * 三、获取通道
 * 1.Java针对支持通道的类提供了getChannel()方法
 * 本地IO:
 * FileInputStream/FileOutputStream
 * RandomAccessFile
 * 网络IO:
 * Socket
 * ServerSocket
 * DatagramSocket
 * 2.在jdk1.7中的NIO.2针对各个通道提供了静态方法open()
 * 3.在jdk1.7中的NIO.2的Files工具类的newByteChannel()
 * <p>
 * 四、通道之间的数据传输
 * transferFrom
 * transferTo
 * <p>
 * 五、分散(Scatter)与聚集(Gather)
 * 分散读取(Scatter Reads):将通道中的数据分散到多个缓冲区
 * 聚集写入(Gathering Writes):将多个缓冲区中的数据聚集到通道中
 * <p>
 * 六、字符集：charset
 * 编码：字符串->字节数组
 * 解码：字节数组->字符串
 *
 * @author iHelin
 * @since 2017/11/20 21:52
 */
public class ChannelTest {

    /**
     * 1.利用通道完成文件的复制
     *
     * @author iHelin
     * @since 2017/11/30 22:16
     */
    @Test
    public void test1() throws IOException {
        FileInputStream inputStream = new FileInputStream("demo/IO.jpg");
        FileOutputStream outputStream = new FileOutputStream("demo/nio1.jpg");
        //获取通道
        FileChannel inputChannel = inputStream.getChannel();
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //将通道中的数据存入缓冲区中
        while (inputChannel.read(byteBuffer) != -1) {
            //切换成[读数据模式]
            byteBuffer.flip();
            //将缓冲区中的数据写入通道中，因为是从byteBuffer中取数据，所以要切换成[读数据模式]
            outputChannel.write(byteBuffer);
            //清空缓冲区
            byteBuffer.clear();
        }
        outputChannel.close();
        inputChannel.close();
        outputStream.close();
        inputStream.close();
    }

    /**
     * 2. 使用直接缓冲区完成文件的复制(内存映射文件)
     *
     * @author iHelin
     * @since 2017/11/30 22:16
     */
    @Test
    public void test2() throws IOException {
        FileChannel inputChannel = FileChannel.open(Paths.get("demo/IO.jpg"), StandardOpenOption.READ);
        FileChannel outputChannel = FileChannel.open(Paths.get("demo/nio2.jpg"), StandardOpenOption.WRITE,
                StandardOpenOption.READ, StandardOpenOption.CREATE);
        //内存映射文件
        MappedByteBuffer inputMappedBuffer = inputChannel.map(FileChannel.MapMode.READ_ONLY,
                0, inputChannel.size());
        MappedByteBuffer outputMappedBuffer = outputChannel.map(FileChannel.MapMode.READ_WRITE,
                0, inputChannel.size());
        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inputMappedBuffer.limit()];
        inputMappedBuffer.get(dst);
        outputMappedBuffer.put(dst);
        //关闭
        inputChannel.close();
        outputChannel.close();
    }


    /**
     * 通道之间的数据传输(直接缓冲区)
     *
     * @author iHelin
     * @since 2017/11/30 22:18
     */
    @Test
    public void test3() throws IOException {
        FileChannel inputChannel = FileChannel.open(Paths.get("demo/IO.jpg"), StandardOpenOption.READ);
        FileChannel outputChannel = FileChannel.open(Paths.get("demo/nio3.jpg"), StandardOpenOption.WRITE,
                StandardOpenOption.READ, StandardOpenOption.CREATE);
        inputChannel.transferTo(0, inputChannel.size(), outputChannel);
//        outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
        inputChannel.close();
        outputChannel.close();
    }

    /**
     * 分散和聚集
     *
     * @author iHelin
     * @since 2017/11/30 22:18
     */
    @Test
    public void test4() throws IOException {
        RandomAccessFile file = new RandomAccessFile("demo/nio1.txt", "rw");
        //1.获取通道
        FileChannel channel1 = file.getChannel();
        //2.分配指定大小的缓冲区
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(100);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        //3.分散读取
        ByteBuffer[] byteBuffers = {byteBuffer1, byteBuffer2};
        channel1.read(byteBuffers);
        for (ByteBuffer byteBuffer : byteBuffers) {
            byteBuffer.flip();
        }
        System.out.println(new String(byteBuffers[0].array(), 0, byteBuffers[0].limit()));
        System.out.println("--------------------------");
        System.out.println(new String(byteBuffers[1].array(), 0, byteBuffers[1].limit()));
        //4.聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("demo/nio2.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(byteBuffers);
    }


}
