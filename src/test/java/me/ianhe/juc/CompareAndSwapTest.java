package me.ianhe.juc;

/**
 * 模拟 CAS 算法
 *
 * @author iHelin
 * @since 2017/11/22 10:13
 */
public class CompareAndSwapTest {

    static class CompareAndSwap {

        private int value;

        /**
         * 获取内存值
         *
         * @return
         */
        public synchronized int get() {
            return value;
        }

        /**
         * 比较
         *
         * @param expectedValue
         * @param newValue
         * @return
         */
        synchronized int compareAndSwap(int expectedValue, int newValue) {
            int oldValue = value;

            if (oldValue == expectedValue) {
                this.value = newValue;
            }

            return oldValue;
        }

        /**
         * 设置
         *
         * @param expectedValue
         * @param newValue
         * @return
         */
        synchronized boolean compareAndSet(int expectedValue, int newValue) {
            return expectedValue == compareAndSwap(expectedValue, newValue);
        }
    }

    public static void main(String[] args) {
        final CompareAndSwap cas = new CompareAndSwap();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int expectedValue = cas.get();
                boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
                System.out.println(b);
            }).start();
        }
    }

}
