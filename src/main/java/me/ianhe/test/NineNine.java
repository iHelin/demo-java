package me.ianhe.test;

public class NineNine {

    public static void main(String[] args) {
        for (int j = 1; j < 10; j++) {
            for (int k = 1; k <= j; k++) {
                System.out.print(k + "x" + j + "=" + j * k + " ");
            }
            System.out.println();
        }
    }

}
