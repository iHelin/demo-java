package io.github.ihelin.demo.test.t1;

import java.util.Random;

/**
 * @author iHelin
 * @since 2019-03-12 10:47
 */
public class ServerThread extends Thread {

    private final Random random;

    private final RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.random = new Random(seed);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles " + request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException ignored) {
                
            }
        }
    }
}
