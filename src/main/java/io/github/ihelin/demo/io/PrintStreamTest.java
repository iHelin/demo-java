package io.github.ihelin.demo.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author iHelin
 * @date 2019-01-30 15:55
 */
public class PrintStreamTest {


    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("demo/printStream.txt");
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
}
