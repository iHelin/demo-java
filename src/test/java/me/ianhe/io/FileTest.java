package me.ianhe.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * java.io.File类用于表示文件（目录）
 * File类只用于表示文件（目录）的信息（名称、大小等），不能用于文件内容的访问
 *
 * @author iHelin
 * @since 2017/8/3 15:05
 */
public class FileTest {

    @Test
    public void test() throws Exception {
        File file = new File("demo/test");
        if (!file.exists())
            file.mkdirs();
        /*else
            file.delete();*/
        //是否是一个目录 是目录返回true，不是目录or目录不存在返回false
        System.out.println(file.isDirectory());
        //是否是一个文件
        System.out.println(file.isFile());

        File file2 = new File("demo/test", "1.txt");
        if (!file2.exists())
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        else
            file2.delete();
        //File类常用API
        System.out.println(file);//file.toString()的内容
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file2.getName());
        System.out.println(file.getParent());
        System.out.println(file2.getFreeSpace());
    }

}