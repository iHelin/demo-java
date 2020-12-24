package io.github.ihelin.demo.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

/**
 * @author iHelin
 * @date 2019-02-27 10:57
 */
public class OutputStreamWriterTest {

    /**
     * 写入文件
     *
     * @author iHelin
     * @since 2017/11/27 18:07
     */
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("demo/outputStreamWriter.txt");
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,
                StandardCharsets.UTF_8)) {
            outputStreamWriter.write("这是要保存的中文字符");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
