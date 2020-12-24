package io.github.ihelin.demo.basic;

public class Test {

    /**
     * 计算a+aa+aaa+aaaa+aaaaa的和
     *
     * @param args
     */
    public static void main(String[] args) {
        int n = 3;
        int sum = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            tmp = tmp * 10 + n;
            sum += tmp;
        }
        System.out.println(sum);
    }

}
