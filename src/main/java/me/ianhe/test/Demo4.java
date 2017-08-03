package me.ianhe.test;

public class Demo4 {
    public void methodA(String str, Integer... is) {
        System.out.println(1);
    }

    public void methodA(String str, String... is) {
        System.out.println(2);
    }

    public static void main(String[] args) {
        Demo4 dm = new Demo4();
        dm.methodA("China", 0);
        dm.methodA("China", "people");
//        dm.methodA("China");
        String[] str = null;
        dm.methodA("China", str);

    }

}
