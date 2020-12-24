package io.github.ihelin.demo.test.t2;

import java.io.IOException;
import java.util.Random;

/**
 * @author iHelin
 * @date 2019-03-14 10:27
 */
public class ChangerThread extends Thread {

    private final Data data;
    private final Random random = new Random();

    public ChangerThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                data.change("No." + i);
                Thread.sleep(random.nextInt(1000));
                data.save();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
