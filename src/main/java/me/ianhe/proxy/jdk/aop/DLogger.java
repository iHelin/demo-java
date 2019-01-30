package me.ianhe.proxy.jdk.aop;

/**
 * @author iHelin
 * @date 2019-01-30 10:44
 */
public class DLogger implements ILogger {

    @Override
    public void start(String str) {
        System.out.println(str + " say hello start...");
    }

    @Override
    public void end(String str) {
        System.out.println(str + " say hello end");
    }
}
