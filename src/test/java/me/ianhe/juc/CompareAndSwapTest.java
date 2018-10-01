package me.ianhe.juc;

/**
 * 模拟 CAS 算法
 *
 * @author iHelin
 * @since 2017/11/22 10:13
 */
public class CompareAndSwapTest {

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

    static class CompareAndSwap {

        private volatile int value;

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
         * @param expectedValue 预估值
         * @param newValue
         * @return
         */
        synchronized int compareAndSwap(int expectedValue, int newValue) {
            int val = get();

            if (val == expectedValue) {
                this.value = newValue;
            }

            return val;
        }

        /**
         * 设置
         *
         * @param expectedValue 预估值
         * @param newValue      新值
         * @return
         */
        synchronized boolean compareAndSet(int expectedValue, int newValue) {
            return expectedValue == compareAndSwap(expectedValue, newValue);
        }
    }

}
