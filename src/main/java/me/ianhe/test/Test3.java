package me.ianhe.test;

/**
 * @author iHelin
 * @since 2017/11/20 18:16
 */
public class Test3 {
    private static void test(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            try {
                if (arr[i] % 2 == 0) {
                    throw new NullPointerException();
                } else {
                    System.out.print(i);
                }
            } finally {
                System.out.println("e");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        /*for (int i = 0; i < 128; i++) {
            System.out.print("i=" + i);
            System.out.print(((char) i) + "\t");
            if (i % 10 == 0) {
                System.out.println();
            }
        }*/

        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b);

       /* try {
            test(new int[]{0, 1, 2, 3, 4, 5});
        } catch (Exception e) {
            System.out.println("E");
        }finally {
            System.out.println(1234);
        }*/
    }

}
