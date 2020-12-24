package me.ianhe.basic.exception;

/**
 * 异常测试
 *
 * @author iHelin
 * @since 2017/11/20 18:19
 */
public class ExceptionTest {

    public static void main(String[] args) {
        try {
            foo();
            bar();
        } catch (Exception e) {
            System.out.println("异常被我捕获了：" + e.getMessage());
        } finally {
            System.out.println("12345");
        }
        System.out.println("program is still running here!");
    }

    private static void foo() throws ArithmeticException {
        int x = 5 / 0;
        System.out.println(x);
    }

    private static void bar() throws BlogAppException {
        System.out.println("let's assume BlogAppException happened when executing `create` command");
        // 为了演示，这里我们假设执行create命令时，抛出了异常
        throw new BlogAppException("create exception");
    }

}
