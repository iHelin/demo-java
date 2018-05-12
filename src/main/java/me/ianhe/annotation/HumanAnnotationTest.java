package me.ianhe.annotation;

import me.ianhe.model.Student;

import java.lang.reflect.Method;

/**
 * Human注解测试
 *
 * @author iHelin
 * @since 2018/4/27 11:47
 */
public class HumanAnnotationTest {

    public static void main(String[] args) {
        Student student = new Student();
        Method[] fields = Student.class.getDeclaredMethods();
        for (Method field : fields) {
            if (field.isAnnotationPresent(Human.class)) {
                Human humanAnnotation = field.getAnnotation(Human.class);
                student.setStudentName(humanAnnotation.studentName());
                student.setStudentNo(humanAnnotation.studentNo());
                student.setStudentAge(humanAnnotation.studentAge());
            }
        }
        System.out.println(student);
    }

}
