package me.ianhe.juc.p1;

/**
 * @author iHelin
 * @since 2018/9/22 22:56
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Testing Gate,Hit CTRL+C to exit");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
