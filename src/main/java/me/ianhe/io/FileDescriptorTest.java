package me.ianhe.io;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author iHelin
 * @since 2017/11/29 15:25
 */
public class FileDescriptorTest {

    public static void main(String[] args) {
        try {
            /*
             * FileDescriptor读取示例程序
             * 为了说明，"通过文件名创建FileInputStream"与“通过文件描述符创建FileInputStream”对象是等效的
             */
            // 新建文件“file.txt”对应的FileInputStream对象
            FileInputStream fileInputStream = new FileInputStream("demo/fileOutputStream.txt");
            // 获取文件“file.txt”对应的“文件描述符”
            FileDescriptor fileDescriptor = fileInputStream.getFD();
            // 根据“文件描述符”创建“FileInputStream”对象
            FileInputStream fileInputStream1 = new FileInputStream(fileDescriptor);
            System.out.println("in1.read():" + (char) fileInputStream.read());
            System.out.println("in2.read():" + (char) fileInputStream1.read());
            System.out.printf("fdin(%s) is %s\n", fileDescriptor, fileDescriptor.valid());
            fileInputStream.close();
            fileInputStream1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            /**
             * 标准输出(屏幕)
             * 等价于System.out.print('A');
             */
            FileOutputStream fileOutputStream = new FileOutputStream(FileDescriptor.out);
            fileOutputStream.write('A');
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
