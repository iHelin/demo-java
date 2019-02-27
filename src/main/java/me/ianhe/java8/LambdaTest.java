package me.ianhe.java8;

import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Lambda
 * java8内置的四大核心函数式接口
 * Consumer<T>
 * void accept(T t)
 * Supplier<T>
 * T get()
 * Function<T,R>
 * R apply(T t)
 * Predicate<T>
 * boolean test(T t)
 *
 * @author linhe2
 * @since 2018/7/28 19:03
 */
public class LambdaTest {

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test6();
        test7();
        test8();
    }

    /**
     * 无参数，无返回值
     *
     * @author linhe2
     * @since 2018/7/28 18:35
     */
    private static void test1() {
        Runnable r1 = () -> System.out.println("Hello lambda");
        r1.run();
    }

    /**
     * 1参数，无返回值
     */
    private static void test2() {
        Consumer<String> c = System.out::println;
        c.accept("哈哈哈哈哈哈");
    }

    /**
     * 多个参数，有返回值，方法体中只有一条语句
     */
    private static void test3() {
        Comparator<Integer> c = Comparator.comparingInt(x -> x);
        int compare = c.compare(1, 2);
        System.out.println(compare);
    }

    /**
     * 2个参数，有返回值，方法体中多条语句
     */
    private static void test4() {
        Comparator<Integer> c = (x, y) -> {
            System.out.println("哈哈哈哈");
            return Integer.compare(x, y);
        };
        int compare = c.compare(1, 2);
        System.out.println(compare);
    }

    /**
     * Supplier:无参数，又返回值
     */
    private static void test6() {
        Supplier<Integer> supplier = () -> new Random().nextInt(100);
        int length = 10;
        for (int i = 0; i < length; i++) {
            System.out.println(supplier.get());
        }
    }

    /**
     * Function：1参数，有返回值
     */
    private static void test7() {
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.apply("abcdefg"));
    }

    /**
     * Predicate:1参数，返回boolean类型
     */
    private static void test8() {
        Predicate<String> predicate = StringUtils::isEmpty;
        System.out.println(predicate.test("abcd"));
    }
}
