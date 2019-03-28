package me.ianhe.test.t2;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author iHelin
 * @date 2019-03-14 10:20
 */
public class Data {

    private final String filename;

    private String content;

    private boolean changed;

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        doSave();
        changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave,content= " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
