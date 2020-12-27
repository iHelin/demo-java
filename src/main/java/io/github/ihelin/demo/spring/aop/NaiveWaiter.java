package io.github.ihelin.demo.spring.aop;

/**
 * @author iHelin
 * @since 2017-04-15 20:30
 */
public class NaiveWaiter implements Waiter {

    @Override
    public void greetTo(String name) {
        System.out.println("waiter greet to " + name + "...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("waiter serving " + name + "...");
    }
}
