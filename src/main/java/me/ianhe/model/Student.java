package me.ianhe.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author iHelin
 * @since 2017/11/29 14:50
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -2054640916158631512L;
    private String studentNo;
    private String studentName;
    /**
     * transient修饰 该属性不会进行jvm默认的序列化
     * 但是可以自己完成这个元素的序列化，如下readObject()方法和writeObject()方法
     */
    private transient int studentAge;

    public Student() {
        System.out.println("使用无参构造函数");
    }

    public Student(String studentNo, String studentName, int studentAge) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.studentAge = studentAge;
        System.out.println("使用有参构造函数");
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    @Override
    public String toString() {
        return "Student [studentNo=" + studentNo + ", studentName=" + studentName + ", studentAge=" + studentAge + "]";
    }

    private void writeObject(ObjectOutputStream s)
            throws IOException {
        //把虚拟机能默认序列化的元素进行序列化操作
        s.defaultWriteObject();
        //自己完成studentAge的序列化
        s.writeInt(studentAge);
    }

    private void readObject(ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        //把虚拟机能默认序列化的元素进行反序列化操作
        s.defaultReadObject();
        //自己完成studentAge的反序列化操作
        this.studentAge = s.readInt();
    }

}
