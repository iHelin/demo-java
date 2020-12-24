package io.github.ihelin.demo.test.t2;

/**
 * @author iHelin
 * @date 2019-03-14 10:30
 */
public class Main {

    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }
}
