package me.ianhe.test;

import java.text.NumberFormat;

public class Demo2 {
    public void calPrice(int price, int discount) {
        float knockdownPrice = price * discount / 100.0F;
        System.out.println("简单折扣后的价格是：" + formateCurrency(knockdownPrice));
    }

    public void calPrice(int price, int... discounts) {
        float konckdownPrice = price;
        for (int discount : discounts) {
            konckdownPrice = konckdownPrice * discount / 100;
        }
        System.out.println("复杂折扣后的价格是：" + formateCurrency(konckdownPrice));
    }

    private String formateCurrency(float price) {
        return NumberFormat.getCurrencyInstance().format(price / 100);
    }

    public static void main(String[] args) {
        Demo2 dm = new Demo2();
        dm.calPrice(49900, 75);
    }
}
