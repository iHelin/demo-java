package me.ianhe.other.arithmetic.pat.b1015;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author iHelin
 * @since 2018/2/5 10:30
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int h = scanner.nextInt();
        Set<Student> class1 = new TreeSet<>();
        Set<Student> class2 = new TreeSet<>();
        Set<Student> class3 = new TreeSet<>();
        Set<Student> class4 = new TreeSet<>();
        Student student;
        for (int i = 0; i < n; i++) {
            student = new Student();
            student.num = scanner.nextInt();
            student.de = scanner.nextInt();
            student.cai = scanner.nextInt();
            if (student.de >= l && student.cai >= l) {
                if (student.de >= h && student.cai >= h) {
                    class1.add(student);
                } else if (student.de >= h) {
                    class2.add(student);
                } else if (student.de >= student.cai) {
                    class3.add(student);
                } else {
                    class4.add(student);
                }
            }
        }
        scanner.close();
        System.out.println(class1.size() + class2.size() + class3.size() + class4.size());
        print(class1);
        print(class2);
        print(class3);
        print(class4);
    }

    private static void print(Set<Student> set) {
        for (Student s : set) {
            System.out.println(s.num + " " + s.de + " " + s.cai);
        }
    }

    static class Student implements Comparable<Student> {
        int num;
        int de;
        int cai;

        @Override
        public int compareTo(Student o) {
            if ((cai + de) != (o.cai + o.de)) {
                return o.cai + o.de - cai - de;
            } else if (de != o.de) {
                return o.de - de;
            } else {
                return num - o.num;
            }
        }
    }

}
