package me.ianhe.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * FileInputStream 是文件输入流，它继承于InputStream。
 * 通常使用FileInputStream从某个文件中获得输入字节。
 * FileOutputStream 是文件输出流，它继承于OutputStream。
 * 通常使用FileOutputStream将数据写入File或FileDescriptor的输出流。
 *
 * @author iHelin
 * @since 2017/8/11 16:53
 */
public class FileInputStreamAndFileOutputStreamTest {

    /**
     * @author iHelin
     * @since 2017/11/29 14:43
     */
    @Test
    public void testFileInputStream() {
        //统计文件字节长度
        int count = 0;
        try (FileInputStream fileInputStream = new FileInputStream(new File("demo/IO.jpg"))) {
            // FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。读取文件字节，并递增指针到下一个字节
            while (fileInputStream.read() != -1) {
                count++;
            }
            //FileInputStream不支持mark/reset操作；BufferedInputStream支持此操作
            System.out.println("markSupported:" + fileInputStream.markSupported());
            System.out.println("文件长度是： " + count + " 字节");
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @author iHelin
     * @since 2017/11/29 14:43
     */
    @Test
    public void testFileOutputStream() throws Exception {
        // 如果该文件不存在，则直接创建，如果存在，则删除后创建
        FileOutputStream fileOutputStream = new FileOutputStream("demo/fileOutputStream.txt");//如要追加，则参数后append true
        // 写出了'A'的低八位
        fileOutputStream.write('A');
        // 写出了'B'的低八位
        fileOutputStream.write('B');
        // write只能写八位，那么写一个int需要写4次，每次8位
        int a = 10;
        fileOutputStream.write(a >>> 24);
        fileOutputStream.write(a >>> 16);
        fileOutputStream.write(a >>> 8);
        fileOutputStream.write(a);
        byte[] utf8 = "中国".getBytes(StandardCharsets.UTF_8);
        fileOutputStream.write(utf8);
        fileOutputStream.close();
    }

    /**
     * 使用PrintStream写入
     *
     * @author iHelin
     * @since 2017/11/29 15:10
     */
    @Test
    public void testWrite() throws IOException {
        File file = new File("demo/fileOutputStream.txt");
        // 创建FileOutputStream对象，默认是关闭“追加模式”
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        // 创建FileOutputStream对应的PrintStream，方便操作。PrintStream的写入接口更便利
        PrintStream printStream = new PrintStream(fileOutputStream);
        // 向“文件中”写入26个字母
        printStream.print("abcdefghijklmnopqrstuvwxyz");
        printStream.close();
        // 创建文件“file.txt”对应的FileOutputStream对象，打开“追加模式”
        FileOutputStream fileOutputStream1 = new FileOutputStream(file, true);
        // 创建FileOutputStream对应的PrintStream，方便操作。PrintStream的写入接口更便利
        PrintStream printStream1 = new PrintStream(fileOutputStream1);
        // 向“文件中”写入"0123456789"+换行符
        printStream1.println("0123456789");
        printStream1.close();
    }

    /**
     * FileInputStream 演示程序
     *
     * @author iHelin
     * @since 2017/11/29 15:23
     */
    @Test
    public void testRead() throws IOException {
        // 方法1：新建FileInputStream对象
        File file = new File("demo/fileOutputStream.txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        // 方法2：新建FileInputStream对象
        FileInputStream fileInputStream1 = new FileInputStream("demo/fileOutputStream.txt");

        // 方法3：新建FileInputStream对象
        // 获取文件“file.txt”对应的“文件描述符”
        FileDescriptor fileDescriptor = fileInputStream1.getFD();
        // 根据“文件描述符”创建“FileInputStream”对象
        FileInputStream fileInputStream2 = new FileInputStream(fileDescriptor);

        // 测试read()，从中读取一个字节
        char c1 = (char) fileInputStream.read();
        System.out.println("c1=" + c1);

        // 测试skip(long byteCount)，跳过25个字节
        fileInputStream.skip(25);

        // 测试read(byte[] buffer, int byteOffset, int byteCount)
        byte[] buf = new byte[10];
        fileInputStream.read(buf, 0, buf.length);
        System.out.println("buf=" + (new String(buf)));
        // 创建“FileInputStream”对象对应的BufferedInputStream
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream2);
        // 读取一个字节
        char c2 = (char) bufferedInputStream.read();
        System.out.println("c2=" + c2);

        fileInputStream.close();
        fileInputStream1.close();
        fileInputStream2.close();
    }
}
