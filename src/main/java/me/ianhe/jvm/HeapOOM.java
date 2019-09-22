package me.ianhe.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆
 * 加上JVM参数
 * -verbose:gc -Xms10M -Xmx10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author iHelin
 * @since 2018/3/9 16:45
 */
public class HeapOOM {

    private static class OOMObject {
        private byte[] bigSize = new byte[1024 * 1024];
//        private ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }


}
