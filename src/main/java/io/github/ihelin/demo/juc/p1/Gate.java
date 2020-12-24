package io.github.ihelin.demo.juc.p1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author iHelin
 * @since 2018/9/22 22:58
 */
public class Gate {

    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    private final Lock lock = new ReentrantLock();

    public void pass(String name, String address) {
        try {
            lock.lock();
            this.counter++;
            this.name = name;
            this.address = address;
            check();
        } finally {
            lock.unlock();
        }

    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("****** BROKEN ******* " + toString());
        }
    }

    @Override
    public String toString() {
        return "No." + counter +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


}
