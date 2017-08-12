package me.ianhe.io;

import me.ianhe.model.Student;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author iHelin
 * @since 2017/8/12 10:38
 */
public class ObjectStreamTest {

    @Test
    public void testObjectStream() throws Exception {
        String file = "demo/ObjectStream.txt";
        //1.对象序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        Student student = new Student("1001", "张三", 12);
        oos.writeObject(student);
        oos.flush();
        oos.close();
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        Student stu = (Student) ois.readObject();
        System.out.println(stu);
        ois.close();
    }
}
