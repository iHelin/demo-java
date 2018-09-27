package me.ianhe.my.datasource;

/**
 * @author iHelin
 * @since 2017/8/2 17:45
 */
public class MyPoolFactory {
    public static class CreatePool {
        public static IMyPool myPool = new MyDefaultPool();
    }

    public static IMyPool getInstance() {
        return CreatePool.myPool;
    }
}
