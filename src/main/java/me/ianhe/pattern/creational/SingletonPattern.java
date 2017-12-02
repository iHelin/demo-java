package me.ianhe.pattern.creational;

import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

/**
 * 单例模式
 * 即一个类只允许存在一个实例。
 *
 * @author iHelin
 * @since 2017/8/3 15:39
 */
public class SingletonPattern {

    /**
     * 终极版:volatile
     * 懒汉式，线程安全，在使用时初始化示例（懒加载）
     */
    static class Singleton2 {
        private static volatile Singleton2 instance;

        private Singleton2() {
            new AssertionError("don't support reflect.");
        }

        public static Singleton2 getInstance() {
            if (instance == null) {
                synchronized (Singleton2.class) {
                    if (instance == null) {
                        instance = new Singleton2();
                    }
                }
            }
            return instance;
        }
    }

    /**
     * 饿汉式 static final field，在类被被类加载器加载时便创建实例
     */
    static class Singleton3 {

        private static final Singleton3 instance = new Singleton3();

        private Singleton3() {
            new AssertionError("don't support reflect.");
        }

        public static Singleton3 getInstance() {
            return instance;
        }
    }

    /**
     * 使用静态内部类 static nested class ,这种方法是《Effective Java》上所推荐的
     */
    static class Singleton4 {
        private static class SingletonHolder {
            private static final Singleton4 INSTANCE = new Singleton4();
        }

        private Singleton4() {
            new AssertionError("don't support reflect.");
        }

        public static final Singleton4 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 使用枚举，这也是单例模式最简单的实现 ,这种方法也是《Effective Java》上所推荐的
     */
    public enum Singleton5 {
        INSTANCE
    }

    @Test
    public void testEquals() {
        Assert.assertTrue(Objects.equals(Singleton2.getInstance(), Singleton2.getInstance()));
        Assert.assertTrue(Objects.equals(Singleton3.getInstance(), Singleton3.getInstance()));
        Assert.assertTrue(Objects.equals(Singleton4.getInstance(), Singleton4.getInstance()));
        Assert.assertTrue(Objects.equals(Singleton5.INSTANCE, Singleton5.INSTANCE));
    }
}
