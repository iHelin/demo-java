package me.ianhe.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * nio测试
 *
 * @author iHelin
 * @since 2017/11/20 09:53
 */
public class NIOTest {


    public static void main(String[] args) throws IOException {
        method1();
//        method2();
//        method3();
//        method4();
//        method5();
//        server();
    }

    public static void method1() throws IOException {
        String rFile = "demo/nio_read.txt";
        String wFile = "demo/nio_write.txt";
        FileChannel rFileChannel = new FileInputStream(rFile).getChannel();
        FileChannel wFileChannel = new FileOutputStream(wFile).getChannel();
        ByteBuffer buff = ByteBuffer.allocate(1024);
        while (rFileChannel.read(buff) > 0) {
            buff.flip();
            wFileChannel.write(buff);
            buff.clear();
        }
        close(wFileChannel);
        close(rFileChannel);
    }

    public static void method2() throws IOException {
        String rFile = "demo/nio_read.txt";
        String wFile = "demo/nio_write.txt";
        FileChannel rFileChannel = new FileInputStream(rFile).getChannel();
        FileChannel wFileChannel = new FileOutputStream(wFile).getChannel();

        rFileChannel.transferTo(0, rFileChannel.size(), wFileChannel);

        close(wFileChannel);
        close(rFileChannel);
    }

    public static void method3() throws IOException {
        String rFile = "demo/nio_read.txt";
        String wFile = "demo/nio_write.txt";
        RandomAccessFile raf = new RandomAccessFile(rFile, "rw");
        FileChannel randomChannel = raf.getChannel();
        FileChannel wFileChannel = new FileOutputStream(wFile).getChannel();

        // 将Channel中的所有数据映射成ByteChannel
        ByteBuffer buff = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, raf.length());

        // 把Channel的指针移动到最后
        randomChannel.position(raf.length());
        wFileChannel.write(buff);

        close(wFileChannel);
        close(randomChannel);
    }

    public static void method4() {
        try (InputStream in = new BufferedInputStream(new FileInputStream("nio_read.txt"))) {
            byte[] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while (bytesRead != -1) {
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print((char) buf[i]);
                }
                bytesRead = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void method5() {
        try (RandomAccessFile aFile = new RandomAccessFile("demo/nio_read.txt", "rw")) {
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(6);
            int bytesRead = fileChannel.read(buf);
            System.out.println("read:" + bytesRead);
            while (bytesRead != -1) {
                buf.flip();
                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }
                /*
                 * 或者clear()方法
                 */
                buf.compact();
                bytesRead = fileChannel.read(buf);
                System.out.println("\nread:" + bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
