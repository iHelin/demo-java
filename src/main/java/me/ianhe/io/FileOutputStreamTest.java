package me.ianhe.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author iHelin
 * @date 2019-01-30 15:53
 */
public class FileOutputStreamTest {

    public static void main(String[] args) throws IOException {
        // 如果该文件不存在，则直接创建，如果存在，则删除后创建
        //如要追加，则参数后append true
        FileOutputStream fileOutputStream = new FileOutputStream("demo/fileOutputStream.txt");
        // 写出了'A'的低八位
        fileOutputStream.write('A');
        // 写出了'B'的低八位
        fileOutputStream.write('B');
        byte[] utf8 = "中国".getBytes(StandardCharsets.UTF_8);
        fileOutputStream.write(utf8);
        fileOutputStream.close();
    }
}
