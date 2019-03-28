package me.ianhe.test.t1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author iHelin
 * @date 2019-03-12 10:40
 */
public class RequestQueue {

    private final Queue<Request> queue = new LinkedList<>();

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public /*synchronized*/ Request getRequest() {
        try {
            lock.lock();

            while (queue.peek() == null) {
                try {
//                    wait();
                    condition.await();
                } catch (InterruptedException ignored) {
                }
            }
            return queue.remove();

        } finally {
            lock.unlock();
        }

    }

    public /*synchronized*/ void putRequest(Request request) {
        try {
            lock.lock();

            queue.offer(request);

//            notifyAll();
            condition.signal();
        } finally {
            lock.unlock();
        }
    }
}
