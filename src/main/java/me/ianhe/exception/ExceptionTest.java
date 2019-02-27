package me.ianhe.exception;

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

    static class BlogAppException extends Exception {

        private static final long serialVersionUID = -1642464697243698132L;

        /**
         * 可以给自定义异常增加成员变量，用以保存额外的异常信息
         */
        private String command;

        public BlogAppException(String command) {
            super(command);
            this.command = command;
        }

        @Override
        public String toString() {
            return "Exception happened when executing command " + command;
        }
    }
}
