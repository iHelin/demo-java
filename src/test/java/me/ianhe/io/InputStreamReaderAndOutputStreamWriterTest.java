package me.ianhe.io;

import org.apache.commons.lang3.CharEncoding;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 字符流测试
 *
 * @author iHelin
 * @since 2017/11/27 17:48
 */
public class InputStreamReaderAndOutputStreamWriterTest {


    /**
     * 写入文件
     *
     * @author iHelin
     * @since 2017/11/27 18:07
     */
    @Test
    public void testOutputStreamWriter() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("demo/outputStreamWriter.txt");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, CharEncoding.UTF_8);
        try {
            outputStreamWriter.write("这是要保存的中文字符");
        } finally {
            outputStreamWriter.close();
        }
    }

    /**
     * 从文件读
     *
     * @author iHelin
     * @since 2017/11/27 18:07
     */
    @Test
    public void testInputStreamReader() throws Exception {
        //读取字节转换成字符
        FileInputStream fileInputStream = new FileInputStream("demo/inputStreamReader.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, CharEncoding.UTF_8);
        StringBuffer buffer = new StringBuffer();
        char[] chars = new char[64];
        int count;
        try {
            while ((count = inputStreamReader.read(chars)) > 0) {
                buffer.append(chars, 0, count);
            }
        } finally {
            inputStreamReader.close();
        }
        System.out.println(buffer.toString());
    }
}
