package me.ianhe.juc;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList/CopyOnWriteArraySet : “写入并复制”
 * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销非常的大。并发迭代操作多时可以选择。
 *
 * @author iHelin
 * @since 2017/11/22 10:16
 */
public class CopyOnWriteArrayListTest {

    static class HelloThread implements Runnable {

        private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        static {
            list.add("AA");
            list.add("BB");
            list.add("CC");
        }

        @Override
        public void run() {

            for (String aList : list) {
                System.out.println(aList);
                list.add("AA");
            }

        }

    }

    public static void main(String[] args) {
        HelloThread ht = new HelloThread();

        for (int i = 0; i < 5; i++) {
            new Thread(ht).start();
        }
    }

}