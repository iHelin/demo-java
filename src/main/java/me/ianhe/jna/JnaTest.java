package me.ianhe.jna;

import java.lang.management.ManagementFactory;

/**
 * @author iHelin
 * @since 2018/9/26 09:56
 */
public class JnaTest {

    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.split("@")[0];

        CLibrary.INSTANCE.printf("Hello, World\n");
        CLibrary.INSTANCE.printf("pid is:%s\n", pid);
        for (int i = 0; i < args.length; i++) {
            CLibrary.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
        }
    }

}
