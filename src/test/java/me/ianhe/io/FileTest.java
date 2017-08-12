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

    /**
     * 文件处理示例
     *
     * @author iHelin
     * @since 2017/8/11 16:52
     */
    @Test
    public void test() throws Exception {
        File fileFolder = new File("demo/test");
        if (!fileFolder.exists())
            fileFolder.mkdirs();
        //是否是一个目录 是目录返回true，不是目录or目录不存在返回false
        System.out.println("fileFolder是部目录吗？" + fileFolder.isDirectory());
        //是否是一个文件
        System.out.println("fileFolder是文件吗？" + fileFolder.isFile());

        File file = new File(fileFolder, "1.txt");
        if (!file.exists())
            try {
                file.createNewFile();//当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
            } catch (IOException e) {
                e.printStackTrace();
            }
        //File类常用API
        System.out.println("fileFolder.toString():" + fileFolder);//file.toString()的内容
        System.out.println("fileFolder.getAbsolutePath():" + fileFolder.getAbsolutePath());
        System.out.println("fileFolder.getName():" + fileFolder.getName());
        System.out.println("fileFolder.getParent():" + fileFolder.getParent());
        System.out.println("file.getName():" + file.getName());
        System.out.println("file.getFreeSpace():" + file.getFreeSpace() / (1024.0f * 1024 * 1024) + "G");
        System.out.println("该分区大小" + file.getTotalSpace() / (1000.0f * 1000 * 1000) + "G");
    }

}