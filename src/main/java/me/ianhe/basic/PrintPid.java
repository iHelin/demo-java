package me.ianhe.basic;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * @author iHelin
 * @date 2019-04-17 16:06
 */
public class PrintPid {

    public static void main(String[] args) {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        Integer pid = Integer.valueOf(runtimeMXBean.getName().split("@")[0]);
        System.out.println(pid);
    }
}
