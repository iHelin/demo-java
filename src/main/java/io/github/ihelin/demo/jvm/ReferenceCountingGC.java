package io.github.ihelin.demo.jvm;

/**
 * VM options:-verbose:gc或-XX:+PrintGCDetails
 *
 * @author iHelin
 * @date 2019-01-15 17:20
 */
public class ReferenceCountingGC {

    private Object instance = null;
    private static final int ONE_MB = 1024 * 1024;

    /**
     * 这个成员属性唯一的作用就是占用一点内存
     */
    private final byte[] bigSize = new byte[2 * ONE_MB];

    public static void main(String[] args) {
        ReferenceCountingGC objectA = new ReferenceCountingGC();
        ReferenceCountingGC objectB = new ReferenceCountingGC();
        objectA.instance = objectB;
        objectB.instance = objectA;
        objectA = null;
        objectB = null;

        System.gc();
    }
}
