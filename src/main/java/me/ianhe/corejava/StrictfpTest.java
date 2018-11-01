package me.ianhe.corejava;

/**
 * 使用strictfp关键字精确计算
 *
 * @author iHelin
 * @date 2018/10/20 11:19
 */
public class StrictfpTest {

    public static strictfp void main(String[] args) {
        double w = Double.MAX_VALUE * Integer.MAX_VALUE / Integer.MAX_VALUE;
        System.out.println(w);
    }
}
