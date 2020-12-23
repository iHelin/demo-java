package me.ianhe.io.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

/**
 * 一、缓冲区（Buffer）：在Java NIO中负责数据的存取，缓冲区就是数组，用于存储不同类型的数据
 * 根据数据类型不同（boolean除外），提供了相应类型的缓冲区：
 * ByteBuffer
 * CharBuffer
 * ShortBuffer
 * IntBuffer
 * LongBuffer
 * FloatBuffer
 * DoubleBuffer
 * 上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 * <p>
 * 二、缓冲区存取数据的两个和兴方法：
 * put():存入数据到缓冲区
 * get():获取缓冲区中的数据
 * <p>
 * 三、缓冲区中的四个核心属性：
 * capacity:容量，表示缓冲区中最大存储数据的容量。一旦声明不能改变。
 * limit:界限，表示缓冲区中可以操作数据的大小。（limit后面的数据不能进行读写）
 * position:位置，正在操作缓冲区中数据的位置
 * mark:标记，表示记录当前position的位置。可以通过reset()恢复到mark的位置
 * 0 <= mark <= position <= limit <= capacity
 * <p>
 * 四、直接缓冲区与非直接缓冲区：
 * 非直接缓冲区：通过allocate()方法分配缓冲区，将缓冲区建立在JVM的内存中
 * 直接缓冲区：通过allocateDirect()方法直接缓冲区，将缓冲区建立在物理内存中，可以提高效率
 *
 * @author iHelin
 * @since 2017/11/20 19:55
 */
public class BufferTest {

    /**
     * ByteBuffer基本用法
     * ByteBuffer分配的大小不能小于字符串长度，否则会报BufferOverflowException
     *
     * @author iHelin
     * @since 2017/11/28 22:31
     */
    @Test
    public void test1() {
        String str = "abcdefg";
        //1.分配一个指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println("-----------allocate()-----------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //2.利用put()存入数据到缓冲区
        byteBuffer.put(str.getBytes());
        System.out.println("-----------put()-----------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //3.切换成读取数据的模式
        byteBuffer.flip();
        System.out.println("-----------flip()-----------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //4. 利用get()读取缓冲数据
        byte[] dst = new byte[byteBuffer.limit()];
        byteBuffer.get(dst);
        System.out.println("-----------get()-----------------");
        System.out.println(new String(dst, 0, dst.length));

        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //5.rewind():可重复读数据
        byteBuffer.rewind();
        System.out.println("-----------rewind()-----------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        //6.clear():清空缓冲区，只是指针移到初始化，缓冲区中的数据依然存在，但是处于"被遗忘"状态
        byteBuffer.clear();
        System.out.println("-----------clear()-----------------");
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        System.out.println((char) byteBuffer.get());
    }

    /**
     * mark()和reset()的使用
     *
     * @author iHelin
     * @since 2017/11/28 22:45
     */
    @Test
    public void test2() {
        String str = "abcde";
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes());
        buffer.flip();
        byte[] dst = new byte[buffer.limit()];
        buffer.get(dst, 0, 2);
        System.out.println(new String(dst, 0, 2));
        System.out.println(buffer.position());
        //mark():标记
        buffer.mark();
        buffer.get(dst, 2, 2);
        System.out.println(new String(dst, 2, 2));
        System.out.println(buffer.position());
        //reset():恢复到mark的位置
        buffer.reset();
        System.out.println(buffer.position());

        //判断缓冲区中是否还有剩余数据
        if (buffer.hasRemaining()) {
            //获取缓冲区中可以操作的数量
            System.out.println(buffer.remaining());
        }
    }

    /**
     * 直接缓冲区的使用，allocateDirect
     *
     * @author iHelin
     * @since 2017/11/28 22:47
     */
    @Test
    public void test3() {
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        System.out.println(buf.isDirect());
    }

}
