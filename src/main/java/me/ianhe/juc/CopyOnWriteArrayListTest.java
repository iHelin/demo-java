package me.ianhe.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList/CopyOnWriteArraySet : “写入并复制”
 * 注意：添加操作多时，效率低，因为每次添加时都会进行复制，开销非常的大；并发迭代操作多时可以选择。
 *
 * @author iHelin
 * @since 2017/11/22 10:16
 */
public class CopyOnWriteArrayListTest {

    public static void main(String[] args) {
        HelloThread ht = new HelloThread();

        for (int i = 0; i < 5; i++) {
            new Thread(ht).start();
        }
    }

    static class HelloThread implements Runnable {

        //        private static List<String> list = Collections.synchronizedList(new ArrayList<>());

        /**
         * 没有了并发修改异常，效率不高
         */
        private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        static {
            list.add("AA");
            list.add("BB");
            list.add("CC");
        }

        @Override
        public void run() {

            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
                list.add("AA");
            }

        }

    }

}