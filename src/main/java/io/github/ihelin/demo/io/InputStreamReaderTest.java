package io.github.ihelin.demo.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @author iHelin
 * @date 2019-02-27 10:58
 */
public class InputStreamReaderTest {

    /**
     * 从文件读
     *
     * @author iHelin
     * @since 2017/11/27 18:07
     */
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("demo/inputStreamReader.txt");
        try (InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8)) {
            StringBuilder stringBuilder = new StringBuilder();
            char[] chars = new char[64];
            int count;
            while ((count = inputStreamReader.read(chars)) > 0) {
                stringBuilder.append(chars, 0, count);
            }
            System.out.println(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
