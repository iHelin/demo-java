package io.github.ihelin.demo.test.t1;

/**
 * @author iHelin
 * @since 2019-03-12 10:50
 */
public class Main {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();

        new ClientThread(requestQueue, "Alice", 3141592L).start();
        new ServerThread(requestQueue, "Bobby", 6535897L).start();
    }
}
