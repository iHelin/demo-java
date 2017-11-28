package me.ianhe.io;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author iHelin
 * @since 2017/8/11 16:53
 */
public class FileInputStreamTest {

    @Test
    public void testFileInputStream() {
        int count = 0;  //统计文件字节长度
        InputStream inputStream = null;   //文件输入流
        try {
            inputStream = new FileInputStream(new File("demo/IO.jpg"));
            // FileInputStream是有缓冲区的，所以用完之后必须关闭，否则可能导致内存占满，数据丢失。
            while (inputStream.read() != -1) {  //读取文件字节，并递增指针到下一个字节
                count++;
            }
            //FileInputStream不支持mark/reset操作；BufferedInputStream支持此操作
            System.out.println("markSupported:" + inputStream.markSupported());
            System.out.println("文件长度是： " + count + " 字节");
        } catch (final IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
