package me.ianhe.book;

import java.text.NumberFormat;

/**
 * 可变长参数测试
 *
 * @author iHelin
 * @since 2017/11/20 16:48
 */
public class VariableArityMethods {

    public static void main(String[] args) {
        VariableArityMethods dm = new VariableArityMethods();
        /*
        简单原则，谁的参数简单调用谁，尽量避免这种模糊写法
         */
        dm.calPrice(49900, 75);
    }

    public void calPrice(int price, int discount) {
        float knockdownPrice = price * discount / 100.0F;
        System.out.println("简单折扣后的价格是：" + formatCurrency(knockdownPrice));
    }

    public void calPrice(int price, int... discounts) {
        float konckDownPrice = price;
        for (int discount : discounts) {
            konckDownPrice = konckDownPrice * discount / 100;
        }
        System.out.println("复杂折扣后的价格是：" + formatCurrency(konckDownPrice));
    }

    private String formatCurrency(float price) {
        return NumberFormat.getCurrencyInstance().format(price / 100);
    }
}
