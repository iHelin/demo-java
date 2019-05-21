package me.ianhe.basic;

/**
 * count++易错点
 * int count = 0;
 * int temp = count;
 * count = count+1;
 * count = temp;
 * 所以最后count还是0
 *
 * @author iHelin
 * @since 2017/11/20 17:31
 */
public class PlusPlus {

    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            count = count++;
        }
        /**
         * 输出0
         */
        System.out.println("count=" + count);

        float bugUiOptNum = 0.0F;
        System.out.println(bugUiOptNum);
    }

}
