package me.ianhe.io;

import me.ianhe.basic.annotation.Student;

import java.io.*;

/**
 * @author iHelin
 * @since 2017/8/12 10:38
 */
public class ObjectStreamTest {

    /**
     * @author iHelin
     * @since 2017/11/29 14:49
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "demo/objectStream.txt";
        //1.对象序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        Student student = new Student("1001", "张三", 12);
        objectOutputStream.writeObject(student);
        objectOutputStream.flush();
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        //反序列化不会调用构造函数
        Student newStudent = (Student) objectInputStream.readObject();
        System.out.println(newStudent);
        objectInputStream.close();
    }
}
