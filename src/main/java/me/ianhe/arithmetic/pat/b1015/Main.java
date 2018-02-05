package me.ianhe.arithmetic.pat.b1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO：超时问题
 *
 * @author iHelin
 * @since 2018/2/5 10:30
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();
        String[] s = line.split(" ");
        int n = Integer.valueOf(s[0]);
        int l = Integer.valueOf(s[1]);
        int h = Integer.valueOf(s[2]);
        List<Student> class1 = new ArrayList<>();
        List<Student> class2 = new ArrayList<>();
        List<Student> class3 = new ArrayList<>();
        List<Student> class4 = new ArrayList<>();
        Student student;
        for (int i = 0; i < n; i++) {
            student = new Student();
            line = bufferedReader.readLine();
            s = line.split(" ");
            student.num = s[0];
            student.de = Integer.valueOf(s[1]);
            student.cai = Integer.valueOf(s[2]);
            if (student.de >= l && student.cai >= l) {
                if (student.de >= h && student.cai >= h) {
                    class1.add(student);
                } else if (student.de >= h && student.cai < h) {
                    class2.add(student);
                } else if (student.de < h && student.cai < h && student.de >= student.cai) {
                    class3.add(student);
                } else {
                    class4.add(student);
                }
            }
        }
        bufferedReader.close();
        Collections.sort(class1);
        Collections.sort(class2);
        Collections.sort(class3);
        Collections.sort(class4);

        System.out.printf("%d\n", class1.size() + class2.size() + class3.size() + class4.size());

        for (Student s1 : class1) {
            System.out.printf("%s %d %d\n", s1.num, s1.de, s1.cai);
        }
        for (Student s1 : class2) {
            System.out.printf("%s %d %d\n", s1.num, s1.de, s1.cai);
        }
        for (Student s1 : class3) {
            System.out.printf("%s %d %d\n", s1.num, s1.de, s1.cai);
        }
        for (Student s1 : class4) {
            System.out.printf("%s %d %d\n", s1.num, s1.de, s1.cai);
        }
    }

    static class Student implements Comparable<Student> {
        String num;
        int de;
        int cai;

        @Override
        public int compareTo(Student o) {
            if ((cai + de) != (o.cai + o.de)) {
                return o.cai + o.de - cai - de;
            } else if (de != o.de) {
                return o.de - de;
            } else {
                return num.compareTo(o.num);
            }
        }
    }

}
