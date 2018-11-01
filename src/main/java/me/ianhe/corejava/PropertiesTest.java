package me.ianhe.corejava;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author iHelin
 * @date 2018/10/25 22:41
 */
public class PropertiesTest {

    public static void main(String[] args) throws IOException {
        Properties settings = new Properties();
        settings.put("width", "200");
        settings.put("title", "Hello,World!");
        FileOutputStream out = new FileOutputStream("demo/program.properties");
        settings.store(out, "Program Properties");
    }
}
