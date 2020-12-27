package io.github.ihelin.demo.jvm;

/**
 * VM options:-XX:+PrintGCDetails -Xms30M -Xmx30M -Xmn10M -XX:SurvivorRatio=8
 * -Xmn10M 堆中新生代内存
 * -XX:SurvivorRatio=8 新生代内存中Eden和Survivor大小之比，如果为8表示Eden占80%，另外两个Survivor各占10%
 *
 * @author iHelin
 * @since 2019-01-18 16:19
 */
public class GCLogTest {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().maxMemory() / 1024 + "k");
        System.out.println(Runtime.getRuntime().totalMemory() / 1024 + "k");
        System.out.println(Runtime.getRuntime().availableProcessors());
        Object obj = new Object();
        obj = null;
        System.gc();
    }
}
