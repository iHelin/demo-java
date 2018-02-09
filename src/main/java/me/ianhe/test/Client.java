package me.ianhe.test;

/**
 * @author iHelin
 * @since 2017/11/20 16:43
 */
public class Client {

    public static void main(String[] args) {
        Base base = new Sub();
        base.fun(100, 50);
        //Sub sub = new Sub();
        //sub.fun(100, 50);
    }

    static class Base {
        Base() {
            System.out.println("Base Constructor");
        }

        void fun(int price, int... discounts) {
            System.out.println("Base......fun");
        }
    }

    static class Sub extends Base {
        Sub() {
            System.out.println("Sub Constructor");
        }

        @Override
        void fun(int price, int[] discounts) {
            System.out.println("Sub......fun");
        }
    }
}