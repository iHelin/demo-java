package io.github.ihelin.demo.test;

/**
 * @author iHelin
 * @date 2019-03-20 11:22
 */
public class Test9 {

    private void change(String s) {
        s = "Hello";
    }

    public static void main(String[] args) {
        String a = "world";
        Test9 test9 = new Test9();
        test9.change(a);
        System.out.println(a);
    }
}
