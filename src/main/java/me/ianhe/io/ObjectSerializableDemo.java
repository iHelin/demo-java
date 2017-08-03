package me.ianhe.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectSerializableDemo {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String file = "demo/obj.txt";
		//1.对象序列化
		/*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		Student stu = new Student("1001","张三",12);
		oos.writeObject(stu);
		oos.flush();
		oos.close();*/
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		Student stu = (Student)ois.readObject();
		System.out.println(stu);
		ois.close();
	}

}
