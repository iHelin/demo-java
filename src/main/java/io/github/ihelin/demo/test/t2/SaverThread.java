package io.github.ihelin.demo.test.t2;

import java.io.IOException;

/**
 * @author iHelin
 * @date 2019-03-14 10:24
 */
public class SaverThread extends Thread {

    private final Data data;

    public SaverThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                data.save();
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
