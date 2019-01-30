package me.ianhe.io;

import java.io.*;

/**
 * FileInputStream 是文件输入流，它继承于InputStream。
 * 通常使用FileInputStream从某个文件中获得输入字节。
 * FileOutputStream 是文件输出流，它继承于OutputStream。
 * 通常使用FileOutputStream将数据写入File或FileDescriptor的输出流。
 *
 * @author iHelin
 * @since 2017/8/11 16:53
 */
public class FileInputStreamTest {

    /**
     * @author iHelin
     * @since 2017/11/29 14:43
     */
    public static void main(String[] args) throws IOException {
        //统计文件字节长度
        int count = 0;
        try (FileInputStream fileInputStream = new FileInputStream(new File("demo/IO.jpg"))) {
            // FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。读取文件字节，并递增指针到下一个字节
            while (fileInputStream.read() != -1) {
                count++;
            }
            //FileInputStream不支持mark/reset操作；BufferedInputStream支持此操作
            System.out.println("文件大小是： " + count + " 字节");
            System.out.println("markSupported:" + fileInputStream.markSupported());
        } catch (final IOException e) {
            e.printStackTrace();
        }
        testRead();
    }

    /**
     * FileInputStream 演示程序
     *
     * @author iHelin
     * @since 2017/11/29 15:23
     */
    private static void testRead() throws IOException {
        // 方法1：新建FileInputStream对象
        File file = new File("demo/fileOutputStream.txt");
        FileInputStream fileInputStream1 = new FileInputStream(file);

        // 方法2：新建FileInputStream对象
        FileInputStream fileInputStream2 = new FileInputStream("demo/fileOutputStream.txt");

        // 方法3：新建FileInputStream对象
        // 获取文件“file.txt”对应的“文件描述符”
        FileDescriptor fileDescriptor = fileInputStream1.getFD();
        // 根据“文件描述符”创建“FileInputStream”对象
        FileInputStream fileInputStream3 = new FileInputStream(fileDescriptor);

        // 测试read()，从中读取一个字节
        char c1 = (char) fileInputStream1.read();
        System.out.println("c1=" + c1);

        // 测试skip(long byteCount)，跳过2个字节
        long skipNum = fileInputStream1.skip(2);
        System.out.println("skip " + skipNum + " bytes");

        // 测试read(byte[] buffer, int byteOffset, int byteCount)
        byte[] buf = new byte[20];
        int readNum = fileInputStream1.read(buf, 0, buf.length);
        System.out.println("read " + readNum + " bytes");

        System.out.println("buf=" + new String(buf));
        // 创建“FileInputStream”对象对应的BufferedInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream2);
        // 读取一个字节
        char c2 = (char) bufferedInputStream.read();
        System.out.println("c2=" + c2);

        fileInputStream1.close();
        fileInputStream2.close();
        fileInputStream3.close();
    }
}
