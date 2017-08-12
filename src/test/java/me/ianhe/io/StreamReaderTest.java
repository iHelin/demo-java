package me.ianhe.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 读取文件内容，控制台输出
 *
 * @author iHelin
 * @since 2017/8/12 10:45
 */
public class StreamReaderTest {

    @Test
    public void test() throws Exception {
        FileInputStream in = new FileInputStream("demo/demo.txt");
        InputStreamReader isr = new InputStreamReader(in);
        int c;
        while ((c = isr.read()) != -1) {
            System.out.print((char) c);
        }

        isr.close();
    }
}
