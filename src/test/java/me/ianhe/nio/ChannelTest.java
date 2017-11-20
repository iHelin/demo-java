package me.ianhe.nio;

/**
 * 一、通道(channel):用于源节点与目标节点的连接。
 * 在javaNIO中负责缓冲区中数据的传输。channel本身不存储数据，因此需要配合缓冲区进行传输。
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
 *
 * @author iHelin
 * @since 2017/11/20 21:52
 */
public class ChannelTest {

}
