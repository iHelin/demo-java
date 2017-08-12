package me.ianhe.io;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author iHelin
 * @since 2017/8/12 10:48
 */
public class FileReaderAndFileWriterTest {

    @Test
    public void test() throws Exception {
        FileReader fr = new FileReader("demo/FileReader.txt");
        FileWriter fw = new FileWriter("demo/FileWriter.txt");
        char[] buffer = new char[2056];
        int c;
        while ((c = fr.read(buffer, 0, buffer.length)) != -1) {
            fw.write(buffer, 0, c);
            fw.flush();
        }
        fw.close();
        fr.close();
    }
}
