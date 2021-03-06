package io.github.ihelin.demo.utils;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 列出File类的一些常用操作，比如过滤、遍历等操作
 *
 * @author ihelin
 */
public class FileUtils {

    public static void main(String[] args) {
        FileUtils.listDirectory(new File("/Users/iHelin/Music"));
    }

    /**
     * 列出指定目录下（包括其子目录）的所有文件
     *
     * @param dir 指定的文件夹
     */
    public static void listDirectory(File dir) {
        if (!dir.exists()) {
            throw new IllegalArgumentException("目录：" + dir + "不存在.");
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(dir + "不是一个目录");
        }
        //如果要遍历子目录下的内容就需要构造成File对象作递归操作，File提供了直接返回File对象的API
        //返回的是直接子目录（文件）的抽象
        File[] files = dir.listFiles();
        List<String> extensions = Arrays.asList("mp3", "flac");
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //递归
                    listDirectory(file);
                } else {
                    if (FilenameUtils.isExtension(file.getName(), extensions)) {
                        System.out.println(file.getName());
                    }
                }
            }
        }
    }

    private FileUtils() {
        throw new UnsupportedOperationException("工具类不允许实例化");
    }
}
