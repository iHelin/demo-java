package me.ianhe.basic.annotation;

import java.lang.reflect.Method;

/**
 * Human注解测试
 *
 * @author iHelin
 * @since 2018/4/27 11:47
 */
public class AnnotationTest {

    public static void main(String[] args) {
        Student student = new Student();
        Method[] methods = Student.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Human.class)) {
                Human humanAnnotation = method.getAnnotation(Human.class);
                student.setStudentName(humanAnnotation.studentName());
                student.setStudentNo(humanAnnotation.studentNo());
                student.setStudentAge(humanAnnotation.studentAge());
            }
        }
        System.out.println(student);
    }

}
