package me.ianhe.io;

import org.junit.Test;

import java.io.FileOutputStream;

/**
 * @author iHelin
 * @since 2017/8/3 15:12
 */
public class FileOutputStreamTest {
    @Test
    public void test() throws Exception {
        // 如果该文件不存在，则直接创建，如果存在，则删除后创建
        FileOutputStream fileOutputStream = new FileOutputStream("demo/FileOutputStream.txt");//如要追加，则参数后append true
        fileOutputStream.write('A');// 写出了'A'的低八位
        fileOutputStream.write('B');// 写出了'B'的低八位
        int a = 10;// write只能写八位，那么写一个int需要写4次，每次8位
        fileOutputStream.write(a >>> 24);
        fileOutputStream.write(a >>> 16);
        fileOutputStream.write(a >>> 8);
        fileOutputStream.write(a);
        byte[] utf8 = "中国".getBytes("utf-8");
        fileOutputStream.write(utf8);
        fileOutputStream.close();
    }

}